package com.learning.theoffice.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class DepartmentResponse {

    private Long id;

    private String code;

    private String location;

    private Date recordCreatedDate;
}
