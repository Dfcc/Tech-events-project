package com.example.demo.domain.service;

import com.example.demo.domain.entities.User;

import java.util.List;

public interface IUserService {

    List<User> usersList();


    void saveUser(User user);
    User userFindById(Long id);
    void deleteUser(Long id);

    User findByUsername(String username);

}