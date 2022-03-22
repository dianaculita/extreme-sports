package com.company.service;

import com.company.dto.ExtremeSportDto;
import com.company.mapper.ConvertToDto;
import com.company.model.*;
import com.company.repository.ExtremeSportRepository;
import com.company.repository.SportByPlaceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExtremeSportServiceTest {

    @Mock
    private ExtremeSportRepository extremeSportRepository;

    @Mock
    private SportByPlaceRepository sportByPlaceRepository;

    @InjectMocks
    private ExtremeSportServiceImpl extremeSportService;

    @Test
    public void testGetExtremeSportById() {

        Date startDate = java.sql.Date.valueOf("2022-03-30");
        Date endDate = java.sql.Date.valueOf("2022-10-31");

        ExtremeSport extremeSport = ExtremeSport.builder()
                .sportId(100L)
                .name("mountain biking")
                .startPeriod(startDate)
                .endPeriod(endDate)
                .build();

        Country country = Country.builder().countryId(100L).name("Italia").build();
        Region region = Region.builder().regionId(100L).name("Trentino").build();
        Place place = Place.builder().placeId(100L).name("Canazei").build();

        SportByPlace sportByPlace = SportByPlace.builder()
                .country(country)
                .region(region)
                .place(place)
                .pricePerDay(300L)
                .build();

        when(extremeSportRepository.getExtremeSportBySportId(100L)).thenReturn(Optional.of(extremeSport));
        when(sportByPlaceRepository.findByExtremeSport(extremeSport)).thenReturn(Optional.of(sportByPlace));

        ExtremeSportDto expectedResponse = ConvertToDto.extremeSportToDto(extremeSport, sportByPlace);

        ExtremeSportDto actualResponse = extremeSportService.getExtremeSportById(100L);

        assertEquals(expectedResponse.getName(), actualResponse.getName());
        assertEquals(expectedResponse.getCountry(), actualResponse.getCountry());
        assertEquals(expectedResponse.getRegion(), actualResponse.getRegion());
        assertEquals(expectedResponse.getPlace(), actualResponse.getPlace());
        assertEquals(expectedResponse.getStartPeriod(), actualResponse.getStartPeriod());
        assertEquals(expectedResponse.getEndPeriod(), actualResponse.getEndPeriod());
        assertEquals(expectedResponse.getPricePerDay(), actualResponse.getPricePerDay());

        verify(extremeSportRepository).getExtremeSportBySportId(anyLong());
        verify(sportByPlaceRepository).findByExtremeSport(extremeSport);
        verifyNoMoreInteractions(extremeSportRepository, sportByPlaceRepository);
    }


}
