package com.company.service;

import com.company.dto.ExtremeSportDto;

public interface ExtremeSportService {

    Long addExtremeSport(ExtremeSportDto extremeSportDto);

    ExtremeSportDto getExtremeSportById(Long id);

    void deleteExtremeSportByName(String name);

    void deleteExtremeSportById(Long id);

//    void updateExtremeSport(Long id, ExtremeSportDto extremeSportDto);

}
