package com.ms.entity.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Jay on 2015/9/23.
 */
@Document(collection="User")
public class User {

    private static final long serialVersionUID = -2953239138625761779L;

    @Id
    private String id;// id
    private String name;// Ãû×Ö

    public User() {
    }

    public User( String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return "User2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
