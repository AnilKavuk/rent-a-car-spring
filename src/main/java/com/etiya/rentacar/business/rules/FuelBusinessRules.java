package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.business.messages.FuelMessages;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.dataAccess.abstracts.FuelRepository;
import com.etiya.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class FuelBusinessRules {
    FuelRepository fuelRepository;

    public void FuelNameCanNotBeDuplicated(String fuelName){
        Optional<Fuel> fuel=fuelRepository.findByNameIgnoreCase(fuelName);
        if(fuel.isPresent()){
            throw  new BusinessException(FuelMessages.FuelNameAlreadyExists);
        }
    }
}
