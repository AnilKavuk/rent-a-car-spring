package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.messages.BrandMessages;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.dataAccess.abstracts.CarRepository;
import com.etiya.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private CarService carService;

    public void CarShouldBeAvailabeToSentToMaintenance(String carId){
        boolean isNowState = carService.stateCar(carId);
        if(!isNowState){
            throw new BusinessException(BrandMessages.BrandNameAlreadyExists);
        }
    }
}
