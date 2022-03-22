package com.company.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "SPORTS_BY_PLACES")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SportByPlace {

    @EmbeddedId
    private SportByPlaceId sportByPlaceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sportId")
    @JoinColumn(name = "sport_id")
    private ExtremeSport extremeSport;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("countryId")
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("regionId")
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("placeId")
    @JoinColumn(name = "place_id")
    private Place place;

    @Column(name = "price_per_day")
    private Long pricePerDay;
}
