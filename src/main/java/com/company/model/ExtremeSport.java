package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "EXTREME_SPORTS", uniqueConstraints = { @UniqueConstraint(columnNames = { "sport_id", "sport_name" }) })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExtremeSport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sport_id")
    private Long sportId;

    @Column(name = "sport_name")
    private String name;

    @Column(name = "start_period")
    private Date startPeriod;

    @Column(name = "end_period")
    private Date endPeriod;

    @OneToMany
    @JoinColumn(name = "sport_id")
    private List<SportByPlace> sportByPlaces;

}
