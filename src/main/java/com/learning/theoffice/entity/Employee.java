package com.learning.theoffice.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEES")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "EMPLOYEE_CODE",nullable = false)
    private String generatedNo;

    @Column(name = "NAME",nullable = false,length = 150)
    private String name;

    @Column(name = "POSITION",length = 50,nullable = false)
    private String position;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE",nullable = false)
    private Date recordCreatedDate;

    @Column(name = "CREATED_BY",nullable = false,length = 50)
    private String createdBy;

    @Column(name = "MODIFIED_DATE",nullable = false)
    private Date modifiedDate;

    @Column(name = "MODIFIED_BY",nullable = false,length = 50)
    private String modifiedBy;

    @ColumnDefault("0")
    @Column(name = "ACTIVE_STATUS")
    private Integer status=0;

    @ManyToOne
    @JoinColumn(name = "DEPT_ID",referencedColumnName = "id")
    private Department departmentId;

}
