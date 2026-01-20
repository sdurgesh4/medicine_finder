package com.app.medicine_finder.service;

import com.app.medicine_finder.config.MedicineDataConfig;
import com.app.medicine_finder.dto.MedicineResponseDto;
import com.app.medicine_finder.model.Medicine;
import com.app.medicine_finder.store.MedicineStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineStore medicineStore;

    @Override
    public List<MedicineResponseDto> searchByName(String query) {

        Medicine exact = medicineStore.findExact(query);

        if (exact != null) {
            return List.of(toDto(exact));
        }

        List<Medicine> matches =
                medicineStore.findBySubstring(query);

        if (matches.isEmpty()) {
            throw new RuntimeException("No medicines found");
        }

        return matches.stream()
                .limit(10) // prevent huge responses
                .map(this::toDto)
                .toList();
    }

    private MedicineResponseDto toDto(Medicine m) {

        List<String> ingredients = new ArrayList<>();

        if (m.getComposition1() != null && !m.getComposition1().isBlank())
            ingredients.add(m.getComposition1());

        if (m.getComposition2() != null && !m.getComposition2().isBlank())
            ingredients.add(m.getComposition2());

        return new MedicineResponseDto(
                m.getName(),
                m.getManufacturerName(),
                m.getType(),
                m.getPackSizeLabel(),
                m.getPrice(),
                ingredients,
                "TRUE".equalsIgnoreCase(m.getIsDiscontinued())
        );
    }

}
