package com.company.details;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Details {

    private String countryName;

    private String regionName;

    private String placeName;

    private Map<String, Long> extremeSportWithPrice;

}
