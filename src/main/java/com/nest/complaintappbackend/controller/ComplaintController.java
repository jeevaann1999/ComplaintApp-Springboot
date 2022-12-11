package com.nest.complaintappbackend.controller;

import com.nest.complaintappbackend.dao.UserDao;
import com.nest.complaintappbackend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ComplaintController {
    @Autowired
    private UserDao udao;

    @GetMapping("/")
    public String Homepage()
    {
        return "Welcome Page";
    }

    @PostMapping(path = "/userreg", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserRegistration(@RequestBody UserModel u){
        HashMap<String, String> hm=new HashMap<>();
        hm.put("status","success");
        return hm;

    }
}
