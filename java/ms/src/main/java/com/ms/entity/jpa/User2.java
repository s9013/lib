package com.ms.entity.jpa;

import javax.persistence.*;

/**
 * Created by Jay on 2015/9/22.
 */
@Entity
@Table(name="users")
public class User2 {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name="name")
    private String name;


    public User2() {}
    public User2(String name) {
        this.name = name;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
