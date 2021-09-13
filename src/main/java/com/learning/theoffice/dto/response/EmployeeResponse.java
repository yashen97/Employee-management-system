package com.learning.theoffice.dto.response;

import com.learning.theoffice.entity.Department;
import lombok.Data;

import java.util.Date;
@Data
public class EmployeeResponse {

    private Long id;

    private String generatedNo;

    private String name;

    private String position;

    private Date recordCreatedDate;

    private String createdBy;

    private Date modifiedDate;

    private String modifiedBy;

    private Integer status;

    private Department departmentId;
}
