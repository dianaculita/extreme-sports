package com.company.service;

import com.company.dto.RegionDto;

public interface RegionService {

    Long addRegion(RegionDto regionDto);

    RegionDto getById(Long id);

    void deleteRegion(Long id);
}
