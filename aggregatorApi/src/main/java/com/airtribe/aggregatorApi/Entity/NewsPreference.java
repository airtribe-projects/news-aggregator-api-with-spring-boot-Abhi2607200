package com.airtribe.aggregatorApi.Entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class NewsPreference {
    public NewsPreference(String category2, String language2, String country2) {
        //TODO Auto-generated constructor stub
    }
    private String category;
    private String country;
    private String language;
}
 