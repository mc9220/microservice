package com.microservice.Userservice.Service;

import com.microservice.Userservice.Entity.User;
import com.microservice.Userservice.Repo.UserRepo;
import com.microservice.Userservice.VO.Department;
import com.microservice.Userservice.VO.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
@Autowired
    private UserRepo userRepo;
@Autowired
private RestTemplate restTemplate;

    public User saveUser(User user) {
    return userRepo.save(user);
    }

    public User findUserById(Long id) {
    return userRepo.findById(id).get();
    }

    public ResponseTemplateVO getUserWithDepartment(Long id) {
        ResponseTemplateVO vo=new ResponseTemplateVO();
        User user=userRepo.findById(id).get();
        Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }
}
