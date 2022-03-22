package com.company.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SportByPlaceId implements Serializable {

    @Column(name = "sport_id")
    private Long sportId;

    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "region_id")
    private Long regionId;

    @Column(name = "place_id")
    private Long placeId;

}
