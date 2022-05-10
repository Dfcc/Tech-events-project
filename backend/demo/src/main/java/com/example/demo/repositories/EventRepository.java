
package com.example.demo.repositories;


import com.example.demo.domain.entities.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findEventsByUsersId(Long userId);
}
