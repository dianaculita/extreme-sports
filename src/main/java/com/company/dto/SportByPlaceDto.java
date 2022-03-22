package com.company.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SportByPlaceDto {

    private Long placeId;

    private Long sportId;

    private Long regionId;

    private Long countryId;

    private Long pricePerDay;
}
