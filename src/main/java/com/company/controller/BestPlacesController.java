package com.company.controller;

import com.company.details.Details;
import com.company.details.DetailsDto;
import com.company.mapper.RequestVariables;
import com.company.service.BestPlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bestPlaces")
public class BestPlacesController {

    private final BestPlacesService bestPlacesService;

    @Autowired
    public BestPlacesController(BestPlacesService bestPlacesService) {
        this.bestPlacesService = bestPlacesService;
    }

    @GetMapping(value = "/searchBy")
    public List<Details> getExtremeSportsBy(@RequestBody RequestVariables requestVariables) {

        return bestPlacesService.getExtremeSportsBy(requestVariables);
    }

}
