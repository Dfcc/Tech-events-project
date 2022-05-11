package com.example.demo.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.sql.Date;

@Entity
@Table(name="events")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private  String description;
    private  String image;
    private Integer max_people =25;
    private Date date;
    private boolean featured;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.PERSIST, CascadeType.MERGE
            })

    @JoinTable(name = "events_user",
    joinColumns = {@JoinColumn(name = "event_id")},
    inverseJoinColumns = {@JoinColumn(name = "user_id")})

    private Set<User> users =new HashSet<>();

    public Integer getMaxPeople() {
        return max_people;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.max_people = max_people;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        date = date;
    }

    public boolean isFeatured() {
        return featured;
    }
    public Set<User> getUsers() {
        return users;
    }

    public Integer getMax_people() {
        return max_people;
    }

    public void setMax_people(Integer max_people) {
        this.max_people = max_people;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", maxPeople=" + max_people +
                ", date=" + date +
                ", featured="+
        '}';
    }


}
