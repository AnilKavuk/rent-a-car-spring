package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.FuelService;
import com.etiya.rentacar.business.dtos.requests.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedFuelResponse;
import com.etiya.rentacar.business.dtos.responses.GetAllFuelResponse;
import com.etiya.rentacar.business.rules.FuelBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.FuelRepository;
import com.etiya.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    private FuelRepository fuelRepository;
    private ModelMapperService modelMapperService;
    private FuelBusinessRules fuelBusinessRules;
    @Override
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest) {
        fuelBusinessRules.FuelNameCanNotBeDuplicated(createFuelRequest.getName());
        Fuel fuel=this.modelMapperService.forRequest().map(createFuelRequest,Fuel.class);

        fuel.setCreatedDate(LocalDateTime.now());

        Fuel createdFuel = fuelRepository.save(fuel);

        CreatedFuelResponse createdFuelResponse=this.modelMapperService.forResponse().map(createdFuel,CreatedFuelResponse.class);

        return createdFuelResponse;
    }

    @Override
    public List<GetAllFuelResponse> getAll() {
        var result = fuelRepository.findAll();

        List<GetAllFuelResponse> response=result.stream().map(fuel -> this.modelMapperService.forResponse()
                .map(fuel, GetAllFuelResponse.class)).collect(Collectors.toList());
        return response;
    }
}
