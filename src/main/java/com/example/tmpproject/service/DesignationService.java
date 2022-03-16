package com.example.tmpproject.service;

import com.example.tmpproject.model.Designation;
import com.example.tmpproject.repository.DesignationRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationService
{
    @Autowired
    private DesignationRepositry designationRepositry;

    public Designation saveDesignation(Designation designation){return  designationRepositry.save(designation);}
    public Designation findDesination(int id){return designationRepositry.findById(id);}
    public List<Designation> findAllDesination(){return designationRepositry.findAllBy();}
    public Designation deleteDesination(int id){return designationRepositry.deleteById(id);}
    public Long count(){return designationRepositry.count();}
}
