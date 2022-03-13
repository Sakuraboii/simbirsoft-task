package org.simbirsoft.dashboard.user.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SIMBIRSOFT_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "username",unique = true)
    @NotNull
    private String username;

    @Column(name = "password")
    @NotNull
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Long getId() {
        return this.id;
    }

    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public User(){

    }
}
