package com.zzbslayer.bookstore.manager;

import com.zzbslayer.bookstore.hibernateUtil.HibernateUtil;
import com.zzbslayer.bookstore.domain.BookEntity;

import java.util.List;
import org.hibernate.Session;

public class BookManager {
    public static void main(String[] args) {
        BookManager mgr = new BookManager();

        List Books = mgr.listBooks();
        for (int i = 0; i < Books.size(); i++) {
            BookEntity Book = (BookEntity) Books.get(i);
            System.out.println(
                    "bookid:" + Book.getBookid()
                    + "\tbookname:" + Book.getBookname()
                    + "\tauther:" + Book.getAuther()
                    + "\tlanguage:" + Book.getLang()
                    + "\tprice:" + Book.getPrice()
                    + "\tyear:" + Book.getYear()
                    + "\tcount:" + Book.getCount()
            );
        }
    HibernateUtil.getSessionFactory().close();
    }

    @SuppressWarnings("unchecked")
    private List<BookEntity> listBooks() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<BookEntity> result = session.createQuery("from BookEntity").list();
        session.getTransaction().commit();
        return result;
    }

    private void createAndStoreBookEntity(Integer bookid, String bookname, String auther, String lang, Float price, Integer year, Integer count, String imgsrc) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        BookEntity BookEntity = new BookEntity();
        BookEntity.setBookid(bookid);
        BookEntity.setBookname(bookname);
        BookEntity.setAuther(auther);
        BookEntity.setLang(lang);
        BookEntity.setYear(year);
        BookEntity.setCount(count);
        BookEntity.setImgsrc(imgsrc);
        session.save(BookEntity);

        session.getTransaction().commit();
    }
}
