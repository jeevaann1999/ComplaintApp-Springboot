package com.nest.complaintappbackend.controller;

import com.nest.complaintappbackend.dao.ComplaintsDao;
import com.nest.complaintappbackend.model.Complaints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ComplaintsController {

    @Autowired
    private ComplaintsDao dao;

    @CrossOrigin(origins="*")
    @PostMapping(path="/addcomplaint",consumes="application/json",produces = "application/json")
    public HashMap<String,String > AddComplaints(@RequestBody Complaints c){
        HashMap<String,String> map=new HashMap<>();
        dao.save(c);
        map.put("status","success");
        return map;

    }

    @CrossOrigin(origins="*")
    @GetMapping(path="/viewallcomplaints")
    public List<Map<String,String>> viewall(){
        return(List<Map<String,String>>) dao.GetComplaints();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/mycomplaint",consumes = "application/json",produces = "application/json")
    public List<Complaints> ViewMyComplaint(@RequestBody Complaints c)
    {
        return (List<Complaints>) dao.ViewMyComplaint(c.getUserID());
    }
}
