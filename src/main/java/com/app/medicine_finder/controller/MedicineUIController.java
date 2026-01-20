package com.app.medicine_finder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedicineUIController {

    @GetMapping("/")
    public String home() {
        return "search";
    }
}

