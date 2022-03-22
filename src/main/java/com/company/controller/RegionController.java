package com.company.controller;

import com.company.dto.RegionDto;
import com.company.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/region")
public class RegionController {

    private RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @PostMapping(value = "/createNew")
    public Long addRegion(@RequestBody RegionDto regionDto) {
        return regionService.addRegion(regionDto);
    }

    @GetMapping(value = "/{id}")
    public RegionDto getRegion(@PathVariable Long id) {
        return regionService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRegion(@PathVariable Long id) {
        regionService.deleteRegion(id);
    }
}
