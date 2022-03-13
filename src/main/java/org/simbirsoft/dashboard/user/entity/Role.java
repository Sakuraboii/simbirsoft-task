package org.simbirsoft.dashboard.user.entity;

import javax.persistence.*;

@Entity
@Table(name = "SIMBIRSOFT_ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
