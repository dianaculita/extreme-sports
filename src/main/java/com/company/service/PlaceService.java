package com.company.service;

import com.company.dto.PlaceDto;

public interface PlaceService {

    Long addPlace(PlaceDto placeDto);

    PlaceDto getById(Long id);

    void deletePlace(Long id);
}
