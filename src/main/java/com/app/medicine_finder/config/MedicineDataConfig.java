package com.app.medicine_finder.config;

import com.app.medicine_finder.model.Medicine;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "medicine")
@Getter
@Setter
public class MedicineDataConfig {

    private List<Medicine> medicines;
}


