package com.learning.theoffice.controller;
import com.learning.theoffice.dto.request.DepartmentRequest;
import com.learning.theoffice.dto.response.DepartmentResponse;
import com.learning.theoffice.entity.Department;
import com.learning.theoffice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Dept")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping()
    public ResponseEntity<DepartmentResponse> save(@RequestBody DepartmentRequest departmentRequest){
        DepartmentResponse response =departmentService.save(departmentRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("all")
    public List<Department> saveAll(@RequestBody List<Department> departmentList){
        return departmentService.saveAll(departmentList);
    }

    @GetMapping("all")
    public ResponseEntity<List<DepartmentResponse>> getAll(){
        List<DepartmentResponse> departmentResponseList=departmentService.getAll();
        return ResponseEntity.ok(departmentResponseList);
    }


}
