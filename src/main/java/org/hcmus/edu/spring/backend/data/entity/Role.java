package org.hcmus.edu.spring.backend.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role extends AbstractEntity{

    public final static String OPERATOR = "Operator";
    public final static String TEACHER = "Teacher";

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
