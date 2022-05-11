package com.example.demo.security;

import com.example.demo.domain.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <User> user = Optional.ofNullable(userRepository.findByUsername(username));
        user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + username));
        return user.map(MyUserDetails::new).get();
    }
}
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        User.UserBuilder builder = null;
//
//        if (user != null){
//            builder = User.withUsername(username);
//            builder.disabled(false);
//            builder.password(user.getPassword());
//            builder.authorities(new SimpleGrantedAuthority(user.getRole()));
//            //builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
//        }
//        else{
//            throw new UsernameNotFoundException("User not found");
//        }
//        return builder.build();
//    }
//}
