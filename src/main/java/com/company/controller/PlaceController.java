package com.company.controller;

import com.company.dto.PlaceDto;
import com.company.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/place")
public class PlaceController {

    private PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping(value = "/createNew")
    public Long addPlace(@RequestBody PlaceDto placeDto) {
        return placeService.addPlace(placeDto);
    }

    @GetMapping(value = "/{id}")
    public PlaceDto getPlace(@PathVariable Long id) {
        return placeService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
    }

}
