package com.example.tmpproject.service;

import com.example.tmpproject.model.UserRole;
import com.example.tmpproject.repository.UserRoleRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepositry userRoleRepositry;
    public UserRole saveUserRole(UserRole userRole)
    {
        return userRoleRepositry.save(userRole);
    }
}
