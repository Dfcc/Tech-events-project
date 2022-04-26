package com.example.demo.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="events")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private  String description;
    private  String image;
    private Integer maxPeople =25;
    private Integer Date;


    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
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


    public Integer getDate() {
        return Date;
    }

    public void setDate(Integer date) {
        Date = date;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", maxPeople=" + maxPeople +
                ", Date=" + Date +
                '}';
    }
}
