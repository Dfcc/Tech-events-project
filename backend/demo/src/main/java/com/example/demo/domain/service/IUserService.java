package com.example.demo.domain.service;

import com.example.demo.domain.entities.User;

import java.util.List;

public interface IUserService {

    public List<User> usersList();


    public void saveUser(User user);
    public User userFindById(Long id);
    public void deleteUser(Long id);
}