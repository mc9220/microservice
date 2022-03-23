package com.microservice.Userservice.Controller;

import com.microservice.Userservice.Entity.User;
import com.microservice.Userservice.Service.UserService;
import com.microservice.Userservice.VO.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user)
    {
        return userService.saveUser(user);
    }
//    @GetMapping("/{uid}")
//    public User findUserById(@PathVariable("uid") Long id)
//    {
//        return userService.findUserById(id);
//    }
//

    @GetMapping("/{userid}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("userid") Long id)
    {
        return userService.getUserWithDepartment(id);
    }
}
