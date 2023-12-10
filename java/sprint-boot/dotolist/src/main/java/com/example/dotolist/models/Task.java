package com.example.dotolist.models;

import java.util.Set;
import jakarta.persistence.*;


@Entity
@Table(name = "tasks")
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String detail;

    @Column(columnDefinition = "boolean default false")
    private Boolean isCheck;

    @ManyToMany
    @JoinTable(
      name = "task_tag", 
      joinColumns = @JoinColumn(name = "task_id"), 
      inverseJoinColumns = @JoinColumn(name = "tag_id"),
      uniqueConstraints = @UniqueConstraint(columnNames = {"task_id", "tag_id"})
      )
    Set<Tag> tagList;
}
