package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PLACES", uniqueConstraints = { @UniqueConstraint(columnNames = { "place_id", "place_name" }) })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "place_id")
    private Long placeId;

    @Column(name = "place_name")
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="region_id", nullable = false)
    private Region region;

    @OneToMany
    @JoinColumn(name = "place_id")
    private List<SportByPlace> sportByPlaces;

}
