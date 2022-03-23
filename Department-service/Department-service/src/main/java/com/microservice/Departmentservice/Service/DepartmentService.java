package com.microservice.Departmentservice.Service;

import com.microservice.Departmentservice.Entity.Department;
import com.microservice.Departmentservice.Repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
@Autowired
    private DepartmentRepo departmentRepo;

    public Department saveDepartment(Department department) {
    return departmentRepo.save(department);
    }

    public Department findByDepartmentId(Long id) {
    return departmentRepo.findById(id).get();
    }
}
