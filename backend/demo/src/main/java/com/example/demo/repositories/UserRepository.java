package com.example.demo.repositories;

import com.example.demo.domain.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findUsersByEventsId(Long eventId);
}
