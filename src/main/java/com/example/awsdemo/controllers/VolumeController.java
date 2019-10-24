package com.example.awsdemo.controllers;

import com.example.awsdemo.models.Volume;
import com.example.awsdemo.services.VolumeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/volume")
public class VolumeController {
    VolumeServiceImpl service;

    public VolumeController(VolumeServiceImpl service) {
        this.service = service;
    }

    @GetMapping( value = { "", "/", "/index"})
    public String index(Model model){
        List<Volume> volumeList = service.getInstancesList();
        model.addAttribute("volumeList", volumeList);
        return "volumes";
    }
}
