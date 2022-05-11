package com.example.demo.repositories;

import com.example.demo.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
public User findByUsername(String username);
//   Optional<User> findByUsername(String username);
    List<User> findUsersByEventsId(Long eventId);
}
