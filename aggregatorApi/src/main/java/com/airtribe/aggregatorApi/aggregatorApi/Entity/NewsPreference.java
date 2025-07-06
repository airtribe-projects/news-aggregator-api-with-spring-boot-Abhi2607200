package com.airtribe.aggregatorApi.Entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class NewsPreference {
    private String category;
    private String country;
    private String language;
}
 