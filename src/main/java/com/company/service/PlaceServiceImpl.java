package com.company.service;

import com.company.dto.PlaceDto;
import com.company.mapper.ConvertToDto;
import com.company.model.Place;
import com.company.model.Region;
import com.company.repository.PlaceRepository;
import com.company.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlaceServiceImpl implements PlaceService {

    private PlaceRepository placeRepository;

    private RegionRepository regionRepository;

    @Autowired
    public PlaceServiceImpl(PlaceRepository placeRepository, RegionRepository regionRepository) {
        this.placeRepository = placeRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    public Long addPlace(PlaceDto placeDto) {
        Region region = regionRepository.findById(placeDto.getRegionId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Place place = Place.builder()
                .name(placeDto.getName())
                .region(region)
                .build();

        return placeRepository.save(place).getPlaceId();
    }

    @Override
    public PlaceDto getById(Long id) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ConvertToDto.placeToDto(place);
    }

    @Override
    public void deletePlace(Long id) {
        placeRepository.delete(getPlace(id));
    }

    private Place getPlace(Long id) {
        return placeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
