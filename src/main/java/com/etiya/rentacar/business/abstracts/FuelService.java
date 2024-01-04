package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedFuelResponse;
import com.etiya.rentacar.business.dtos.responses.GetAllFuelResponse;

import java.util.List;

public interface FuelService {
    CreatedFuelResponse add(CreateFuelRequest createFuelRequest);
    
    List<GetAllFuelResponse> getAll();
}
