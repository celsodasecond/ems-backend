package com.celso.emsbackend.service.impl;

import com.celso.emsbackend.dto.EmployeeDto;
import com.celso.emsbackend.entity.Employee;
import com.celso.emsbackend.exception.ResourceNotFoundException;
import com.celso.emsbackend.mapper.EmployeeMapper;
import com.celso.emsbackend.repository.EmployeeRepository;
import com.celso.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee does not exist with the given id : " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto) {
        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id : " + employeeId));

        if (!(updatedEmployeeDto.getFirstName() == null)) {
            employee.setFirstName(updatedEmployeeDto.getFirstName());
        }

        if (!(updatedEmployeeDto.getLastName() == null)) {
            employee.setLastName(updatedEmployeeDto.getLastName());
        }

        if (!(updatedEmployeeDto.getEmail() == null)) {
            employee.setEmail(updatedEmployeeDto.getEmail());
        }

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id : " + employeeId));

        employeeRepository.deleteById(employeeId);
    }

}
