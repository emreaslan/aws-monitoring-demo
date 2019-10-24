package com.example.awsdemo.controllers;

import com.example.awsdemo.models.Instance;
import com.example.awsdemo.services.InstanceServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/instance")
public class InstanceController {
    InstanceServiceImpl service;

    public InstanceController(InstanceServiceImpl service) {
        this.service = service;
    }

    @GetMapping( value = { "", "/", "/index"})
    public String index(Model model){
        List<Instance> instanceList = service.getInstancesList();
        model.addAttribute("instances", instanceList);
        return "instances";
    }

    @GetMapping("/show/{id}")
    public String show(Model model, @PathVariable("id") String id){
        Instance instance = service.getInstanceById(id).orElse(null);
        if (instance != null){
            model.addAttribute("instance", instance);
            return "instance";
        }

        return "error";
    }
}
