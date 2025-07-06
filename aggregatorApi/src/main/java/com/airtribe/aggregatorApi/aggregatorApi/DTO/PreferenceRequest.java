package com.airtribe.aggregatorApi.DTO;

import lombok.Data;

@Data
public class PreferenceRequest {
    private String category;
    private String country;
    private String language;
}
