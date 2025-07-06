package com.airtribe.aggregatorApi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;



// PreferenceResponse.java
@Data
@AllArgsConstructor
public class PreferenceResponse {
    private String category;
    private String country;
    private String language;
}
