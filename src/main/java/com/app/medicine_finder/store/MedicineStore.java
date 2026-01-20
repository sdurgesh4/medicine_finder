package com.app.medicine_finder.store;

import com.app.medicine_finder.model.Medicine;
import com.app.medicine_finder.util.MedicineNameNormalizer;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MedicineStore {

    private final Map<String, Medicine> medicineMap = new HashMap<>();

    public void save(Medicine medicine) {
        String key = MedicineNameNormalizer.normalize(medicine.getName());
        medicineMap.put(key, medicine);
    }

    // Exact match (O(1))
    public Medicine findExact(String name) {
        return medicineMap.get(
                MedicineNameNormalizer.normalize(name)
        );
    }

    public List<Medicine> findBySubstring(String query) {
        String normalizedQuery = MedicineNameNormalizer.normalize(query);

        List<Medicine> results = new ArrayList<>();

        for (Map.Entry<String, Medicine> entry : medicineMap.entrySet()) {
            if (entry.getKey().contains(normalizedQuery)) {
                results.add(entry.getValue());
            }
        }

        return results;
    }

    public int size() {
        return medicineMap.size();
    }
}
