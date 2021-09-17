package com.learning.theoffice.dto.request;

import com.learning.theoffice.entity.Department;
import lombok.Data;
@Data
public class EmployeeRequest {

    //private Long id;

    private String name;

    private String position;

    private String createdBy;

    private String modifiedBy;

    private Integer status;

    private Long departmentId;

}
