package com.learning.theoffice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "DEPT_CODE",nullable = false,length = 50)
    private String code;
    @Column(name = "LOCATION",length = 50,nullable = false)
    private String location;
}
