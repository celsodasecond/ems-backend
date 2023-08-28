package com.celso.emsbackend.service.impl;

import com.celso.emsbackend.dto.DepartmentDto;
import com.celso.emsbackend.entity.Department;
import com.celso.emsbackend.entity.Employee;
import com.celso.emsbackend.exception.ResourceNotFoundException;
import com.celso.emsbackend.mapper.DepartmentMapper;
import com.celso.emsbackend.repository.DepartmentRepository;
import com.celso.emsbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    public DepartmentDto getDepartmentById(Long departmentId) {
        Department savedDepartment = departmentRepository
                .findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department does not exist with the given id: " + departmentId));

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public List<DepartmentDto> getDepartments() {
        List<Department> savedDepartments = departmentRepository.findAll();

        return savedDepartments.stream()
                .map((department -> DepartmentMapper.mapToDepartmentDto(department)))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartmentDto) {
        Department department = departmentRepository
                .findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department does not exist with the given id: " + departmentId));

        if (!(updatedDepartmentDto.getDepartmentName() == null)) {
            department.setDepartmentName(updatedDepartmentDto.getDepartmentName());
        }

        if (!(updatedDepartmentDto.getDepartmentDescription() == null)) {
            department.setDepartmentDescription(updatedDepartmentDto.getDepartmentDescription());
        }

        Department updatedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository
                .findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department does not exist with the given id: " + departmentId));

        departmentRepository.deleteById(departmentId);
    }
}
