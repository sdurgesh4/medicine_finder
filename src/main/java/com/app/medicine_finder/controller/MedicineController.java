package com.app.medicine_finder.controller;

import com.app.medicine_finder.dto.MedicineResponseDto;
import com.app.medicine_finder.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/search")
    public List<MedicineResponseDto> search(
            @RequestParam String q) {

        return medicineService.searchByName(q);
    }
}

