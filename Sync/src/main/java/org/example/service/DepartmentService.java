package org.example.service;

import org.example.model.Department;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);

    List<Department> fetchDepartmentList();

    Department updateDepartment(Department department, Long departmentId);

    void deleteDepartmentId(Long departmentId);

}
