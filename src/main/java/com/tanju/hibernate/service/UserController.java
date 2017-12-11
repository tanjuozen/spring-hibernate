package com.tanju.hibernate.service;

import com.tanju.hibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
        this.userService.add(new User("Sunil", "Bora", "suni.bora@example.com"));
        this.userService.add(new User("David", "Miller", "david.miller@example.com"));
        this.userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        this.userService.add(new User("Paul", "Smith", "paul.smith@example.com"));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> listUsers() {
        return new ResponseEntity<List<User>>(userService.listUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> findUser(@PathVariable Long id) {
        return new ResponseEntity<User>(userService.findOne(id), HttpStatus.OK);
    }
}
