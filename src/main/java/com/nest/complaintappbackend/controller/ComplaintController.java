package com.nest.complaintappbackend.controller;

import com.nest.complaintappbackend.dao.UserDao;
import com.nest.complaintappbackend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userreg", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserRegistration(@RequestBody UserModel um){
        System.out.println(um.getName().toString());
        System.out.println(um.getAddress().toString());
        System.out.println(um.getPhone().toString());
        System.out.println(um.getEmail().toString());
        System.out.println(um.getPassword().toString());
        udao.save(um);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin",consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody UserModel um){
        System.out.println(um.getEmail());
        List<UserModel> result=(List<UserModel>) udao.UserLogin(um.getUsername(),um.getPassword());
        System.out.println(result);
        HashMap<String,String> hm=new HashMap<>();
        if(result.size()==0) {
            hm.put("status", "failed");
            hm.put("message", "user doesn't exist");
        }
        else {
            int id =result.get(0).getId();
            hm.put("userId",String.valueOf(id));
            hm.put("status", "success");
            hm.put("message", "user login success");
        }
        return hm;
    }
}
