package com.example.tmpproject.controller;

import com.example.tmpproject.model.UserRole;
import com.example.tmpproject.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/adduserrole")
    @CrossOrigin(origins = "http://localhost:4200")
    public UserRole SaveUserRole(@RequestBody UserRole userRole)
    {
        return userRoleService.saveUserRole(userRole);
    }

    @PostMapping("/finduserrole")
    @CrossOrigin(origins = "http://localhost:4200")
    public UserRole FindUserRole(@RequestBody UserRole userRole){
        return userRoleService.findUserRole(userRole.getUserroleId());}

    @PostMapping("/findalluserrole")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<UserRole> FindAllUserRole(){return userRoleService.findAllUserRole();}

    @PostMapping("/updateuserrole")
    @CrossOrigin(origins = "http://localhost:4200")
    public UserRole UpdateUserRole(@RequestBody UserRole userRole)
    {
        UserRole userRole1=userRoleService.findUserRole(userRole.getUserroleId());
        userRole1.setUserroleName(userRole.getUserroleName());
        return userRoleService.saveUserRole(userRole1);
    }

    @PostMapping("/deleteuserrole")
    @CrossOrigin(origins = "http://localhost:4200")
    public UserRole DeleteUserRole(UserRole userRole){return userRoleService.deleteUserRole(userRole.getUserroleId());}

}
