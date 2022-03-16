package com.example.tmpproject.service;

import com.example.tmpproject.model.UserRole;
import com.example.tmpproject.repository.UserRoleRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepositry userRoleRepositry;

    public UserRole saveUserRole(UserRole userRole){return userRoleRepositry.save(userRole);}
    public UserRole findUserRole(int id){return userRoleRepositry.findById(id);}
    public List<UserRole> findAllUserRole(){return userRoleRepositry.findAllBy();}
    public UserRole deleteUserRole(int id){return userRoleRepositry.deleteById(id);}
    public Long count(){return userRoleRepositry.count();}
}
