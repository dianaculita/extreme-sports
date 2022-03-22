package com.company.service;

import com.company.dto.CountryDto;

public interface CountryService {

    Long addCountry(CountryDto countryDto);

    CountryDto getById(Long id);

    void deleteCountry(Long id);

}
