package com.celso.emsbackend.service.impl;

import com.celso.emsbackend.dto.DepartmentDto;
import com.celso.emsbackend.entity.Department;
import com.celso.emsbackend.mapper.DepartmentMapper;
import com.celso.emsbackend.repository.DepartmentRepository;
import com.celso.emsbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
