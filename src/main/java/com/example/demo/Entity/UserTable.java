package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "user_table")

public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id ")
    private long id ;

    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    public UserTable() {

    }
    public UserTable(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
