package com.company.service;

import com.company.details.Details;
import com.company.mapper.RequestVariables;

import java.util.List;

public interface BestPlacesService {

    List<Details> getExtremeSportsBy(RequestVariables requestVariables);
}
