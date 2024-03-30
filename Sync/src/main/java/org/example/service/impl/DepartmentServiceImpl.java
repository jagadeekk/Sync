package org.example.service.impl;

import org.example.exception.EntityNotFoundException;
import org.example.model.Department;
import org.example.repository.DepartmentRepository;
import org.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {
        Department depDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(
                department.getDepartmentId())
                && !"".equalsIgnoreCase(
                        department.getDepartmentName())){
            depDB.setDepartmentName(
                    department.getDepartmentName());
        }

        if (Objects.nonNull(
                department.getDepartmentAddress())
                && !"".equalsIgnoreCase(
                department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(
                    department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode())
                && !"".equalsIgnoreCase(
                department.getDepartmentCode())) {
            depDB.setDepartmentCode(
                    department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public void deleteDepartmentId(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
