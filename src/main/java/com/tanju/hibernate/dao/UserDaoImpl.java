package com.tanju.hibernate.dao;

import com.tanju.hibernate.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager factory;

    @Override
    public void add(User user) {
        factory.persist(user);
    }

    @Override
    public List<User> listUsers() {
        return factory.createQuery("select u from User u").getResultList();
    }

    @Override
    public User findOne(long id) {
        return factory.find(User.class, id);
    }
}
