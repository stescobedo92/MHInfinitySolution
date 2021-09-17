package com.mhinfinitysolution.todo.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "scheduled_on")
    private Date scheduledOn;

    public void setId(int id) { this.id = id; }

    public void setTitle(String title) { this.title = title; }

    public void setDescription(String description) { this.description = description; }

    public void setScheduledOn(Date scheduledOn) { this.scheduledOn = scheduledOn; }

    public int getId() { return id; }

    public String getDescription() {
        return description;
    }

    public Date getScheduledOn() {
        return scheduledOn;
    }
}
