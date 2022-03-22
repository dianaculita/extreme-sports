package com.company.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "REGIONS", uniqueConstraints = { @UniqueConstraint(columnNames = { "region_id", "region_name" }) })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "region_id")
    private Long regionId;

    @Column(name = "region_name")
    private String name;

    @OneToMany
    @JoinColumn(name = "region_id")
    private List<Place> places;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id", nullable=false)
    private Country country;

    @OneToMany
    @JoinColumn(name = "region_id")
    private List<SportByPlace> sportByPlaces;

}
