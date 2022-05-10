
package com.example.demo.repositories;


import com.example.demo.domain.entities.Event;
import com.example.demo.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    public List<Event> findByFeaturedIsTrue();

}
