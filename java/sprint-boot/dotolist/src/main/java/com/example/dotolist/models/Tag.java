package com.example.dotolist.models;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;


@Entity
@Table(name = "tags")
public class Tag {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    
    @Column(columnDefinition = "varchar(255)", nullable=false)
    @JsonProperty("title")
    private String title;

    @Column(columnDefinition = "varchar(255) default '#000000", nullable=false)
    @JsonProperty("color")
    private String color;

    public Tag(){

    }

    public Tag(String title, String color) {
        this.title = title;
        this.color = color;
    }

    public Long getId() {
        return this.id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    @ManyToMany(mappedBy = "tagList")
    Set<Task> tasksList;

}
