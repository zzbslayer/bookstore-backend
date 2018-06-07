package com.zzbslayer.bookstore.service.ServiceImpl;

import com.zzbslayer.bookstore.datamodel.dao.*;
import com.zzbslayer.bookstore.datamodel.domain.*;
import com.zzbslayer.bookstore.service.OrderService;
import com.zzbslayer.bookstore.utils.AddressRow;
import com.zzbslayer.bookstore.utils.BookidandCount;
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
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartRepository;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    public List<Order> findOrderByUsername(String username){

        List<Order> orders = orderRepository.findByUsername(username);
        return orders;
    }

    public Order addOrder(List<String> books, String shippingaddress, String recipient, String phone){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        List<BookEntity> orderbooks = new ArrayList<>();
        try{
            Cart cart = cartRepository.findByUsername(name);
            List<BookidandCount> temp = cart.getCart();

            for (String str : books){
                BookEntity book = new BookEntity();
                String[] array = str.split(";");
                //System.out.println(str);
                //System.out.println(array[0]);
                Integer bookid = Integer.parseInt(array[0]);
                Integer count = Integer.parseInt(array[1]);

                //System.out.println("bookid:"+bookid);
                //System.out.println("amount:"+amount);

                BookEntity bookinfo = bookRepository.findByBookid(bookid);
                Integer remain = bookinfo.getCount()-count;
                if (remain<0){
                    logger.debug("Inventory Not Enough");
                    logger.debug("User: "+name+" tend to buy "+count+" "+bookinfo.getBookname());
                    throw new Exception("Inventory Not Enough");
                }
                bookinfo.setCount(remain);

                System.out.println(JSONObject.fromObject(bookinfo).toString());

                book.setCount(count);
                book.setAuthor(bookinfo.getAuthor());
                book.setBookid(bookinfo.getBookid());
                book.setBookname(bookinfo.getBookname());
                book.setImgsrc(bookinfo.getImgsrc());
                book.setLang(bookinfo.getLang());
                book.setPrice(bookinfo.getPrice());
                book.setYear(bookinfo.getYear());

                orderbooks.add(book);
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
            return null;
        }
        Order order = new Order();
        Date now = new Date();
        order.setDate(now.toString());
        order.setUsername(name);
        order.setRecipient(recipient);
        order.setAddress(shippingaddress);
        order.setPhone(phone);
        order.setBooks(orderbooks);
        return orderRepository.save(order);
    }
}
