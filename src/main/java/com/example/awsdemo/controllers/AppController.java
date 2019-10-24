package com.example.awsdemo.controllers;

import com.example.awsdemo.services.DataCollectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    DataCollectionService dataCollectionService;

    public AppController(DataCollectionService dataCollectionService) {
        this.dataCollectionService = dataCollectionService;
    }

    @GetMapping( value = { "", "/", "/index"})
    public String index(Model model){
        model.addAttribute("info", "AWS Monitoring Web Page");
        return "index";
    }

    @GetMapping( value = { "/awsCollectAll"})
    public String collectAll(Model model){
        model.addAttribute("info", "Data retrieved from AWS");
        dataCollectionService.collectAll();
        return "index";
    }

    @GetMapping("/awsInstances")
    public String getInstances(Model model){
        model.addAttribute("info", "Instances retrieved from AWS");
        dataCollectionService.getInstances();
        return "index";
    }

    @GetMapping("/awsSecurityGroups")
    public String getSecurityGroups(Model model){
        model.addAttribute("info", "Security Groups retrieved from AWS");
        dataCollectionService.getSecurityGroups();
        return "index";
    }

    @GetMapping("/awsVolumes")
    public String getVolumes(Model model){
        model.addAttribute("info", "Volumes retrieved from AWS");
        dataCollectionService.getVolumes();
        return "index";
    }
}
