package com.example.awsdemo.controllers;

import com.example.awsdemo.models.Instance;
import com.example.awsdemo.models.SecurityGroup;
import com.example.awsdemo.services.SecurityGroupServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/sg")
public class SecurityGroupController {
    SecurityGroupServiceImpl service;

    public SecurityGroupController(SecurityGroupServiceImpl service) {
        this.service = service;
    }

    @GetMapping( value = { "", "/", "/index"})
    public String index(Model model){
        List<SecurityGroup> sgList = service.getInstancesList();
        model.addAttribute("sgList", sgList);
        return "security-groups";
    }
}
