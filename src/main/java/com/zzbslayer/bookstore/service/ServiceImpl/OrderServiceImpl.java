package com.zzbslayer.bookstore.service.ServiceImpl;

import com.zzbslayer.bookstore.datamodel.dao.*;
import com.zzbslayer.bookstore.datamodel.domain.*;
import com.zzbslayer.bookstore.service.OrderService;
import com.zzbslayer.bookstore.utils.BookidandCount;
import com.zzbslayer.bookstore.utils.OrderwithBooks;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private UserOrderRepository userOrderRepository;
    @Autowired
    private OrderbookRepository orderbookRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartRepository;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    public List<OrderwithBooks> findOrderByUsername(String username){
        List<UserorderEntity> orders= userOrderRepository.findByUsername(username);

        List<OrderwithBooks> orderlist = new ArrayList<>();
        for (UserorderEntity order : orders){
            List<OrderbookEntity> books = orderbookRepository.findByOrderid(order.getOrderid());
            Integer orderid = order.getOrderid();
            Integer addressid = order.getAddressid();
            AddressEntity address = addressRepository.findByAddressid(addressid);
            if (address==null) {
                logger.debug(username + ": Address is null");
            }
            if (books==null) {
                logger.debug(username + ": OrderBooks is null");
            }

            OrderwithBooks o = new OrderwithBooks();
            o.setBooks(books);
            o.setAddress(address);
            o.setOrderid(orderid);
            o.setDate(order.getDate().toString());
            orderlist.add(o);
        }
        return orderlist;
    }

    public UserorderEntity addOrder(List<String> books, Integer addressid){
        UserorderEntity order = new UserorderEntity();
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Date now = new Date();

        order.setUsername(name);
        order.setAddressid(addressid);
        order.setOrderid(0);
        order.setDate(now.toString());
        userOrderRepository.save(order);

        order = userOrderRepository.findByUsernameAndDate(name,now.toString());

        Integer orderid = order.getOrderid();
        try{
            Cart cart = cartRepository.findByUsername(name);
            List<BookidandCount> temp = cart.getCart();

            for (String str : books){
                OrderbookEntity book = new OrderbookEntity();
                String[] array = str.split(";");
                //System.out.println(str);
                //System.out.println(array[0]);
                Integer bookid = Integer.parseInt(array[0]);
                Integer amount = Integer.parseInt(array[1]);

                //System.out.println("bookid:"+bookid);
                //System.out.println("amount:"+amount);

                BookEntity bookinfo = bookRepository.findByBookid(bookid);
                Integer remain = bookinfo.getCount()-amount;
                if (remain<0){
                    logger.debug("Inventory Not Enough");
                    logger.debug("User: "+name+" tend to buy "+amount+" "+bookinfo.getBookname());
                    throw new Exception("Inventory Not Enough");
                }
                bookinfo.setCount(remain);

                System.out.println(JSONObject.fromObject(bookinfo).toString());
                book.setAmount(amount);
                book.setAuthor(bookinfo.getAuthor());
                book.setBookid(bookinfo.getBookid());
                book.setBookname(bookinfo.getBookname());
                book.setImgsrc(bookinfo.getImgsrc());
                book.setLang(bookinfo.getLang());
                book.setPrice(bookinfo.getPrice());
                book.setYear(bookinfo.getYear());
                book.setOrderid(orderid);
                book.setObid(0);

                orderbookRepository.save(book);
                bookRepository.save(bookinfo);

                for (BookidandCount t : temp){
                    if (t.getBookid()==bookid) {
                        temp.remove(t);
                        break;
                    }
                }
                cartRepository.save(cart);
            }
        }
        catch(Exception e){
            userOrderRepository.delete(order);
            return null;
        }
        return order;
    }
}
