package com.company.service;

import com.company.dto.CountryDto;
import com.company.mapper.ConvertToDto;
import com.company.model.Country;
import com.company.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Long addCountry(CountryDto countryDto) {
        Country country = Country.builder()
                .name(countryDto.getName())
                .build();

        return countryRepository.save(country).getCountryId();
    }

    @Override
    public CountryDto getById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ConvertToDto.countryToDto(country);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.delete(getCountryById(id));
    }

    private Country getCountryById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
