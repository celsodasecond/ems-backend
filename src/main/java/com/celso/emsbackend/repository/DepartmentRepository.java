package com.celso.emsbackend.repository;

import com.celso.emsbackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
