package com.company.service;

import com.company.details.Details;
import com.company.details.DetailsDto;
import com.company.mapper.RequestVariables;
import com.company.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class BestPlacesServiceImpl implements BestPlacesService {

    private final ExtremeSportRepository extremeSportRepository;

    private final CountryRepository countryRepository;

    private final RegionRepository regionRepository;

    private final PlaceRepository placeRepository;

    private final SportByPlaceRepository sportByPlaceRepository;

    @Autowired
    public BestPlacesServiceImpl(ExtremeSportRepository extremeSportRepository,
                                 CountryRepository countryRepository,
                                 RegionRepository regionRepository,
                                 PlaceRepository placeRepository,
                                 SportByPlaceRepository sportByPlaceRepository) {

        this.extremeSportRepository = extremeSportRepository;
        this.countryRepository = countryRepository;
        this.regionRepository = regionRepository;
        this.placeRepository = placeRepository;
        this.sportByPlaceRepository = sportByPlaceRepository;
    }

    /*
        Finds the best locations for a sport/list of sports and period (startPeriod-endPeriod),
        ordered by the pricePerDay of the sport.
        - requestVariables - contains the list of sport names, startPeriod and endPeriod for the search
        - requestedDetails - contains a list of details for the best locations,
        consisting of the country, region and place where the sport(s) is(are) practiced and a list of possible
        sports along with their prices per day
     */
    @Override
    public List<Details> getExtremeSportsBy(RequestVariables requestVariables) {

        List<DetailsDto> details = sportByPlaceRepository.getFilteredExtremeSports(requestVariables.getSportNames(),
                requestVariables.getStartDate(), requestVariables.getEndDate())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        List<Details> requiredDetails = new ArrayList<>();

        for (DetailsDto detail : details) {
            Map<String, Long> extremeSportWithPrice = new HashMap<>();
            extremeSportWithPrice.put(detail.getExtremeSport(), detail.getPricePerDay());

            Details requiredDetail = Details.builder()
                    .countryName(countryRepository.getById(detail.getCountryId()).getName())
                    .regionName(regionRepository.getById(detail.getRegionId()).getName())
                    .placeName(placeRepository.getById(detail.getPlaceId()).getName())
                    .extremeSportWithPrice(extremeSportWithPrice)
                    .build();

            requiredDetails.add(requiredDetail);
        }

        return requiredDetails;
    }

}
