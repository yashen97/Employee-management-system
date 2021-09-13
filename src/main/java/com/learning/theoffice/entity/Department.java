package com.learning.theoffice.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DEPARTMENT")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "DEPT_NAME",length = 20,nullable = false)
    private String name;

    @Column(name = "DEPT_CODE",nullable = false,length = 50)
    private String code;

    @Column(name = "LOCATION",length = 50,nullable = false)
    private String location;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RECORD_CREATED_DATE",nullable = false)
    private Date recordCreatedDate;
}
