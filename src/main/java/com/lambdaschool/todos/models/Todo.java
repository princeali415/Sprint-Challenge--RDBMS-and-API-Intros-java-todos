package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    private String description;

    private boolean completed = false;

    // foreign key of user Many to one (not null)
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties(value = "todos")
    private User user;

    // Constructor

    public Todo(
        User user,
        String description
        )
    {
        this.user = user;
        this.description = description;

    }

    public Todo()
    {
        //required by JPA
    }

    // getters and setters

    public long getTodoid()
    {
        return todoid;
    }

    public void setTodoid(long todoid)
    {
        this.todoid = todoid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
