package com.company.mapper;

import com.company.dto.*;
import com.company.model.*;

public class ConvertToDto {

    public static CountryDto countryToDto(Country country) {
        return CountryDto.builder()
                .countryId(country.getCountryId())
                .name(country.getName())
                .build();
    }

    public static RegionDto regionToDto(Region region) {
        return RegionDto.builder()
                .regionId(region.getRegionId())
                .name(region.getName())
                .countryId(region.getCountry().getCountryId())
                .build();
    }

    public static PlaceDto placeToDto(Place place) {
        return PlaceDto.builder()
                .placeId(place.getPlaceId())
                .name(place.getName())
                .regionId(place.getRegion().getRegionId())
                .build();
    }

    public static ExtremeSportDto extremeSportToDto(ExtremeSport extremeSport, SportByPlace sportByPlace) {
        ExtremeSportDto extremeSportDto =  ExtremeSportDto.builder()
                .sportId(extremeSport.getSportId())
                .name(extremeSport.getName())
                .startPeriod(extremeSport.getStartPeriod().toLocalDate())
                .endPeriod(extremeSport.getEndPeriod().toLocalDate())
                .build();

        extremeSportDto.setCountry(sportByPlace.getCountry().getName());
        extremeSportDto.setRegion(sportByPlace.getRegion().getName());
        extremeSportDto.setPlace(sportByPlace.getPlace().getName());
        extremeSportDto.setPricePerDay(sportByPlace.getPricePerDay());

        return extremeSportDto;
    }

    public static SportByPlaceDto sportByPlaceToDto(SportByPlace sportByPlace) {
        return SportByPlaceDto.builder()
                .countryId(sportByPlace.getCountry().getCountryId())
                .regionId(sportByPlace.getRegion().getRegionId())
                .placeId(sportByPlace.getPlace().getPlaceId())
                .sportId(sportByPlace.getExtremeSport().getSportId())
                .pricePerDay(sportByPlace.getPricePerDay())
                .build();
    }
}
