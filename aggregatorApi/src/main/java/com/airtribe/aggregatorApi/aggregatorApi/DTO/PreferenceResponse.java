package com.airtribe.aggregatorApi.DTO.PreferenceResponse

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PreferenceRequest {
    private String category;
    private String country;
    private String language;
}

// PreferenceResponse.java
@Data
@AllArgsConstructor
public class PreferenceResponse {
    private String category;
    private String country;
    private String language;
}
