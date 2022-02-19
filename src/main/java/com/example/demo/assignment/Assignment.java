package com.example.demo.assignment;

import javax.persistence.*;

@Entity
@Table
public class Assignment {
    @Id
    @SequenceGenerator(
            name="assignment_sequence",
            sequenceName="assignment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "assignment_sequence"
    )
    private Long id;
    private String name;

    public Assignment() {
    }

    public Assignment(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
