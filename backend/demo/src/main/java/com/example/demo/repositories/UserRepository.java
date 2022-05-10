package com.example.demo.repositories;

import com.example.demo.domain.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findUsersByEventsId(Long eventId);
}
