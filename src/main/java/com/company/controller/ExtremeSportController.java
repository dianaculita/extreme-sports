package com.company.controller;

import com.company.dto.ExtremeSportDto;
import com.company.service.ExtremeSportService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/extremeSports")
public class ExtremeSportController {

    private ExtremeSportService extremeSportService;

    @Autowired
    public ExtremeSportController(ExtremeSportService extremeSportService) {
        this.extremeSportService = extremeSportService;
    }

    @GetMapping(value = "/{id}")
    public ExtremeSportDto getExtremeSportById(@PathVariable Long id) {
        return extremeSportService.getExtremeSportById(id);
    }

    @PostMapping(value = "/createNew")
    public Long addExtremeSport(@RequestBody ExtremeSportDto extremeSportDto) {
        return extremeSportService.addExtremeSport(extremeSportDto);
    }

    @DeleteMapping(value = "/deleteByName/{name}")
    public void deleteExtremeSportByName(@PathVariable String name) {
        extremeSportService.deleteExtremeSportByName(name);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteExtremeSportById(@PathVariable Long id) {
        extremeSportService.deleteExtremeSportById(id);
    }

}
