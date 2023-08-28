package com.celso.emsbackend.controller;

import com.celso.emsbackend.dto.DepartmentDto;
import com.celso.emsbackend.entity.Department;
import com.celso.emsbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
}
