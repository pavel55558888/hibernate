package com.example.hibernate.models;

import jakarta.persistence.*;

@Entity
@Table(name = "hibernates")
public class Hibernates {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    public Hibernates() {
    }

    public Hibernates(String surname, String name, String lastname) {
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Hibernate{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
