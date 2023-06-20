package com.prasan.movie.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
public class Countries {
    @Column(name = "country_name")
    String countryName;
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countries_seq")
    @SequenceGenerator(name = "countries_seq", sequenceName = "countries_seq")
    @Id
    Integer countryId;

    public Countries(String countryName) {
        this.countryName = countryName;
    }
}
