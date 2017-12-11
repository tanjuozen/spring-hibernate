package com.tanju.hibernate.service;

import com.tanju.hibernate.dao.UserDao;
import com.tanju.hibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserDao dao;

    @Transactional
    public void add(User user) {
        dao.add(user);
    }

    @Transactional(readOnly = true)
    public List<User> listUsers(){
        return dao.listUsers();
    }

    @Transactional
    public User findOne(long id) {
        return dao.findOne(id);
    }
}
