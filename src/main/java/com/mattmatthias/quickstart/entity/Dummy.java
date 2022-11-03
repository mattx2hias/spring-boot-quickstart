package com.mattmatthias.quickstart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="dummy")
public class Dummy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date")
    private long creationDate;

    public Dummy(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Dummy(String name) {
        this.name = name;
    }
}
