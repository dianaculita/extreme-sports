package com.company.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COUNTRIES", uniqueConstraints = { @UniqueConstraint(columnNames = { "country_id", "country_name" }) })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "country_name")
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private List<Region> regions;

    @OneToMany
    @JoinColumn(name = "country_id")
    private List<SportByPlace> sportByPlaces;
}
