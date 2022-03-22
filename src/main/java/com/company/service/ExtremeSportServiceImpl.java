package com.company.service;

import com.company.dto.ExtremeSportDto;
import com.company.mapper.ConvertToDto;
import com.company.model.ExtremeSport;
import com.company.model.SportByPlace;
import com.company.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ExtremeSportServiceImpl implements ExtremeSportService {

    private final ExtremeSportRepository extremeSportRepository;

    private final SportByPlaceRepository sportByPlaceRepository;

    private final CountryRepository countryRepository;

    private final RegionRepository regionRepository;

    private final PlaceRepository placeRepository;

    @Autowired
    public ExtremeSportServiceImpl(ExtremeSportRepository extremeSportRepository,
                                   SportByPlaceRepository sportByPlaceRepository,
                                   CountryRepository countryRepository,
                                   RegionRepository regionRepository,
                                   PlaceRepository placeRepository) {
        this.extremeSportRepository = extremeSportRepository;
        this.sportByPlaceRepository = sportByPlaceRepository;
        this.countryRepository = countryRepository;
        this.regionRepository = regionRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public Long addExtremeSport(ExtremeSportDto extremeSportDto) {
        ExtremeSport extremeSport = ExtremeSport.builder()
                .name(extremeSportDto.getName())
                .startPeriod(java.sql.Date.valueOf(extremeSportDto.getStartPeriod()))
                .endPeriod(java.sql.Date.valueOf(extremeSportDto.getEndPeriod()))
                .build();

        SportByPlace sportByPlace = SportByPlace.builder()
                .country(countryRepository.getByName(extremeSportDto.getCountry()))
                .region(regionRepository.getByName(extremeSportDto.getRegion()))
                .place(placeRepository.getByName(extremeSportDto.getPlace()))
                .pricePerDay(extremeSportDto.getPricePerDay())
                .build();

        sportByPlaceRepository.save(sportByPlace);
        return extremeSportRepository.save(extremeSport).getSportId();
    }

    @Override
    public ExtremeSportDto getExtremeSportById(Long id) {
        ExtremeSport extremeSport = extremeSportRepository.getExtremeSportBySportId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        SportByPlace sportByPlace = sportByPlaceRepository.findByExtremeSport(extremeSport)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ConvertToDto.extremeSportToDto(extremeSport, sportByPlace);
    }

    @Override
    public void deleteExtremeSportByName(String name) {
        ExtremeSport extremeSport = extremeSportRepository.getExtremeSportByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        SportByPlace sportByPlace = sportByPlaceRepository.findByExtremeSport(extremeSport)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        extremeSportRepository.deleteById(extremeSport.getSportId());
        sportByPlaceRepository.delete(sportByPlace);
    }

    @Override
    public void deleteExtremeSportById(Long id) {
        ExtremeSport extremeSport = extremeSportRepository.getExtremeSportBySportId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        SportByPlace sportByPlace = sportByPlaceRepository.findByExtremeSport(extremeSport)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        extremeSportRepository.deleteById(id);
        sportByPlaceRepository.delete(sportByPlace);
    }

}
