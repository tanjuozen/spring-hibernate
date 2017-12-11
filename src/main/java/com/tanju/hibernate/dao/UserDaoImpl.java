package com.tanju.hibernate.dao;

import com.tanju.hibernate.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory factory;

    @Override
    public void add(User user) {
        factory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        Query query = factory.getCurrentSession().createQuery("from User");
        return query.list();
    }

    @Override
    public User findOne(long id) {
        return factory.getCurrentSession().get(User.class, id);
    }
}
