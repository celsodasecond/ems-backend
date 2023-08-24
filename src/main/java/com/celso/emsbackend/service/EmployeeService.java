package com.celso.emsbackend.service;

import com.celso.emsbackend.dto.EmployeeDto;
import com.celso.emsbackend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getEmployees();
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto);
    void deleteEmployee(Long employeeId);
}
