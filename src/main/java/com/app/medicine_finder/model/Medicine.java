package com.app.medicine_finder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Medicine {

    private String id;

    private String name;

    // ✅ MAP SPECIAL JSON KEY
    @JsonProperty("price(₹)")
    private String price;

    @JsonProperty("manufacturer_name")
    private String manufacturerName;

    private String type;

    @JsonProperty("pack_size_label")
    private String packSizeLabel;

    @JsonProperty("short_composition1")
    private String composition1;

    @JsonProperty("short_composition2")
    private String composition2;

    @JsonProperty("Is_discontinued")
    private String isDiscontinued;
}
