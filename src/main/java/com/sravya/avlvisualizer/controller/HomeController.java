package com.sravya.avlvisualizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/learn")
    public String learn() {
        return "learn";
    }

    @GetMapping("/rotations")
    public String rotations() {
        return "rotations";
    }
}