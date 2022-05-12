package com.example.demo.domain.service;

import com.example.demo.domain.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> usersList() {
        return (List<User>) userRepository.findAll();
    }



    @Override
    public void saveUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User userFindById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
