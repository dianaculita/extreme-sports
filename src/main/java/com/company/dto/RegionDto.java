package com.company.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegionDto {

    private Long regionId;

    private String name;

    private Long countryId;

}
