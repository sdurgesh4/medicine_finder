package com.app.medicine_finder.service;

import com.app.medicine_finder.dto.MedicineResponseDto;

import java.util.List;

public interface MedicineService {
    List<MedicineResponseDto> searchByName(String query);
}

