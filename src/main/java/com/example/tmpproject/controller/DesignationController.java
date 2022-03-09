package com.example.tmpproject.controller;

import com.example.tmpproject.model.Designation;
import com.example.tmpproject.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DesignationController
{
    @Autowired
    private DesignationService designationService;

    @PostMapping("/addDesignation")
    public Designation AddDesignation(@RequestBody Designation designation)
    {
        return designationService.saveDesignation(designation);
    }
}
