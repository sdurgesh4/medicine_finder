package com.app.medicine_finder.loader;

import com.app.medicine_finder.model.Medicine;
import com.app.medicine_finder.store.MedicineStore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Component
public class MedicineDataLoader implements CommandLineRunner {

    @Autowired
    private MedicineStore medicineStore;

    @Override
    public void run(String... args) throws Exception {

        ClassPathResource resource =
                new ClassPathResource("data/indian_medicine_data.json");

        if (!resource.exists()) {
            throw new RuntimeException("Medicine JSON file not found");
        }

        System.out.println("Medicine file size (MB): " + resource.contentLength() / (1024 * 1024));

        ObjectMapper mapper = new ObjectMapper();

        try (InputStream is = resource.getInputStream()) {

            JsonNode root = mapper.readTree(is);

            JsonNode arrayNode;

            // Handle both possible structures
            if (root.isArray()) {
                arrayNode = root;
            } else if (root.has("data")) {
                arrayNode = root.get("data");
            } else {
                throw new RuntimeException("Unknown JSON structure");
            }

            List<Medicine> medicines =
                    mapper.convertValue(
                            arrayNode,
                            new TypeReference<List<Medicine>>() {}
                    );

            for (Medicine m : medicines) {
                if (m.getName() != null && !m.getName().isBlank()) {
                    medicineStore.save(m);
                }
            }

            System.out.println("Medicines loaded into memory: " + medicineStore.size());
        }
    }
}


