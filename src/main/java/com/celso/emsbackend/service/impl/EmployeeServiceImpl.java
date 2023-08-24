package com.celso.emsbackend.service.impl;

import com.celso.emsbackend.dto.EmployeeDto;
import com.celso.emsbackend.entity.Employee;
import com.celso.emsbackend.mapper.EmployeeMapper;
import com.celso.emsbackend.repository.EmployeeRepository;
import com.celso.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
