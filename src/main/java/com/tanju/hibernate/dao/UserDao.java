package com.tanju.hibernate.dao;

import com.tanju.hibernate.entity.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    List<User> listUsers();
    User findOne(long id);
}
