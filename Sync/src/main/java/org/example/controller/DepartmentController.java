package org.example.controller;

import org.example.model.Department;
import org.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*
    this is sync 2 updates
 */
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

 //   @PostMapping("/departments")
    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable("id") Long departmentId) {
        return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));//departmentService.getDepartmentById(departmentId);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId){
        return departmentService.updateDepartment(department, departmentId);
    }

    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentId(departmentId);

        return "Deleted Successfully";
    }
}
