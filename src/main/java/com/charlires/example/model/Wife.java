package com.charlires.example.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by carlos_andonaegui on 3/31/14.
 */
@Entity
public class Wife {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Author husband;

    @OneToMany
    private List<Child> children;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getHusband() {
        return husband;
    }

    public void setHusband(Author husband) {
        this.husband = husband;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
