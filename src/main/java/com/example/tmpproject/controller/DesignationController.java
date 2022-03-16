package com.example.tmpproject.controller;

import com.example.tmpproject.model.Designation;
import com.example.tmpproject.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DesignationController
{
    @Autowired
    private DesignationService designationService;

    @PostMapping("/adddesignation")
    @CrossOrigin(origins = "http://localhost:4200")
    public Designation AddDesignation(@RequestBody Designation designation){return designationService.saveDesignation(designation);}

    @PostMapping("/findalldesignation")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Designation> DisplayDesignation(){return designationService.findAllDesination();}

    @PostMapping("/finddesignation")
    @CrossOrigin(origins = "http://localhost:4200")
    public Designation findDesignation(@RequestBody Designation designation){return designationService.findDesination(designation.getDesignationId());}

    @PostMapping("/updatedesignation")
    @CrossOrigin(origins = "http://localhost:4200")
    public Designation UpdateDesignation(@RequestBody Designation designation)
    {
        Designation designation1=designationService.findDesination(designation.getDesignationId());
        designation1.setDesignationName(designation.getDesignationName());
        designation1.setDesignationDescription(designation.getDesignationDescription());
        return designationService.saveDesignation(designation1);
    }

    @PostMapping("/deletedesignation")
    @CrossOrigin(origins = "http://localhost:4200")
    public Designation DeleteDesignation(@RequestBody Designation designation){return designationService.deleteDesination(designation.getDesignationId());}

    @PostMapping("/dashboarddes")
    @CrossOrigin(origins = "http://localhost:4200")
    public Long DesignationCount(){return designationService.count();}


}
