package com.company.service;

import com.company.dto.RegionDto;
import com.company.mapper.ConvertToDto;
import com.company.model.Country;
import com.company.model.Region;
import com.company.repository.CountryRepository;
import com.company.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RegionServiceImpl implements RegionService {

    private RegionRepository regionRepository;

    private CountryRepository countryRepository;

    @Autowired
    public RegionServiceImpl(RegionRepository regionRepository, CountryRepository countryRepository) {
        this.regionRepository = regionRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Long addRegion(RegionDto regionDto) {
        Country country = countryRepository.findById(regionDto.getCountryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Region region = Region.builder()
                .name(regionDto.getName())
                .country(country)
                .build();

        return regionRepository.save(region).getRegionId();
    }

    @Override
    public RegionDto getById(Long id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ConvertToDto.regionToDto(region);
    }

    @Override
    public void deleteRegion(Long id) {
        regionRepository.delete(getRegion(id));
    }

    private Region getRegion(Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
