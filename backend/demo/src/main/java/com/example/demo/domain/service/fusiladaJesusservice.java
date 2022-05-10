//package com.example.demo.domain.service;
//
//import com.techevents.techevents.entity.Events;
//import com.techevents.techevents.entity.Users;
//import com.techevents.techevents.repository.UsersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UsersServiceImpl implements IUsersService{
//
//    @Autowired
//    BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//    @Override
//    public List<Users> listarTodos() {
//        return (List<Users>)usersRepository.findAll();}
//
//    @Override
//    public void guardar (Users users){
//        users.setPassword(passwordEncoder.encode(users.getPassword()));
//        usersRepository.save(users);
//    }
//
//    @Override
//    public Users buscadorPorId(Long id){
//
//        return usersRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void eliminar(Long id){
//        usersRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Events> listaEvents(){
//        return null;
//    }
//
//    @Override
//    public Users findByUsername(String username){
//        return usersRepository.findByUsername(username);
//    }
//
//}