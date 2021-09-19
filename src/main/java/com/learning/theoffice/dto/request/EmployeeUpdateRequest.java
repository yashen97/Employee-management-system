package com.learning.theoffice.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeUpdateRequest {

    private String generatedNo;

    private String name;

    private String position;

    private String modifiedBy;

    private Integer status;

    private Long departmentId;
}
