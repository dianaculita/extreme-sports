package com.company.controller;

import com.company.dto.CountryDto;
import com.company.model.Country;
import com.company.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping(value = "/createNew")
    public Long addCountry(@RequestBody CountryDto countryDto) {
        return countryService.addCountry(countryDto);
    }

    @GetMapping(value = "/{id}")
    public CountryDto getCountry(@PathVariable Long id) {
        return countryService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }

}
