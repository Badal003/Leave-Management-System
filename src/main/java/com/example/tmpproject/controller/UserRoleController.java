package com.example.tmpproject.controller;

import com.example.tmpproject.model.UserRole;
import com.example.tmpproject.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;
    @PostMapping("/adduserrole")
    public UserRole SaveUserRole(@RequestBody UserRole userRole)
    {
        return userRoleService.saveUserRole(userRole);
    }
}
