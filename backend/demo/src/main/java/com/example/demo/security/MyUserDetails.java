package com.example.demo.security;

import com.example.demo.domain.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private String username;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.authorities = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }


}
  /*  When I try to log in, I get an error message that says "Bad Credentials". What’s wrong?
        This means that authentication has failed. It doesn’t say why, as it is good practice
        to avoid giving details which might help an attacker guess account names or passwords.

        This also means that if you ask this question in the forum, you will not get an answer unless
        you provide additional information. As with any issue you should check the output from the debug log,
        note any exception stacktraces and related messages. Step through the code in a debugger to see where
        the authentication fails and why. Write a test case which exercises your authentication configuration
        outside of the application. More often than not, the failure is due to a difference in the password
        data stored in a database and that entered by the user. If you are using hashed passwords, make sure
        the value stored in your database is exactly the same as the value produced by the PasswordEncoder
        configured in your application.*/
