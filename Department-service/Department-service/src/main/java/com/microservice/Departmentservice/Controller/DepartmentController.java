package com.microservice.Departmentservice.Controller;

import com.microservice.Departmentservice.Entity.Department;
import com.microservice.Departmentservice.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping
    public Department saveDepartment(@RequestBody  Department department)
    {
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/{id}")
    public Department findByDepartmentId(@PathVariable("id") Long id)
    {
        return departmentService.findByDepartmentId(id);
    }

}
