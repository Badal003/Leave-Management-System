package com.example.tmpproject.service;

import com.example.tmpproject.model.Designation;
import com.example.tmpproject.repository.DesignationRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class DesignationService
{
    @Autowired
    private DesignationRepositry designationRepositry;

    public Designation saveDesignation(Designation designation)
    {
        return  designationRepositry.save(designation);
    }
    public Designation findDesination(int id){return designationRepositry.findById(id);};

}
