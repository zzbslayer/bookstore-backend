package com.zzbslayer.bookstore.manager;

import com.zzbslayer.bookstore.hibernateUtil.HibernateUtil;
import com.zzbslayer.bookstore.domain.UserEntity;

import java.util.List;
import org.hibernate.Session;

public class UserManager {
    public static void main(String[] args) {
        UserManager mgr = new UserManager();

        List Users = mgr.listUsers();
        for (int i = 0; i < Users.size(); i++) {
            UserEntity User = (UserEntity) Users.get(i);
            System.out.println(
                    "username:" + User.getUsername()
                            + "\tpassword:" + User.getPw()
                            + "\temail:" + User.getEmail()
                            + "\tphone:" + User.getPhone()
                            + "\tpermission:" + User.getPermission()
            );
        }
        HibernateUtil.getSessionFactory().close();
    }

    @SuppressWarnings("unchecked")
    private List<UserEntity> listUsers() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<UserEntity> result = session.createQuery("from UserEntity").list();
        session.getTransaction().commit();
        return result;
    }

    private void createAndStoreUserEntity(String username, String pw, String email, String phone, String permission) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        UserEntity UserEntity = new UserEntity();
        UserEntity.setUsername(username);
        UserEntity.setPw(pw);
        UserEntity.setEmail(email);
        UserEntity.setPhone(phone);
        UserEntity.setPermission(permission);
        session.save(UserEntity);

        session.getTransaction().commit();
    }
}