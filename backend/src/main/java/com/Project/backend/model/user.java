package com.Project.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "userdetails")
public class user {
    @Id
    private String token;
    private Double budget;

}
