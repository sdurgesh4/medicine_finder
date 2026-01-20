package com.app.medicine_finder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class MedicineResponseDto {

    private String name;
    private String manufacturer;
    private String type;
    private String packSize;
    private String price;
    private List<String> ingredients;
    private boolean discontinued;
}
