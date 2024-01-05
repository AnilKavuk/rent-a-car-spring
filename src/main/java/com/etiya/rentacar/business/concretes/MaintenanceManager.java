package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.MaintenanceService;
import com.etiya.rentacar.business.dtos.requests.CreateMaintenanceRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedMaintenanceResponse;
import com.etiya.rentacar.business.rules.MaintenanceBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.CarRepository;
import com.etiya.rentacar.dataAccess.abstracts.MaintenanceRepository;
import com.etiya.rentacar.entities.concretes.Car;
import com.etiya.rentacar.entities.concretes.Maintenance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class MaintenanceManager implements MaintenanceService {
    private MaintenanceRepository maintenanceRepository;
    private ModelMapperService modelMapperService;
    private CarRepository carRepository;
    private MaintenanceBusinessRules availableBusinessRules;
    @Override
    public CreatedMaintenanceResponse add(CreateMaintenanceRequest createMaintenanceRequest) {
        availableBusinessRules.CarShouldBeAvailabeToSentToMaintenance(createMaintenanceRequest.getCarId());
        Maintenance maintenance=this.modelMapperService.forRequest().map(createMaintenanceRequest,Maintenance.class);
        maintenance.setCreatedDate(LocalDateTime.now());
        maintenance.setDateSent(LocalDateTime.now());

        Car car = carRepository.getById( Integer.parseInt(createMaintenanceRequest.getCarId()));

        // car state
        car.setState(3);

        carRepository.save(car);

        Maintenance createdMaintenance=maintenanceRepository.save(maintenance);

        CreatedMaintenanceResponse createdMaintenanceResponse=this.modelMapperService.forResponse()
                .map(createdMaintenance,CreatedMaintenanceResponse.class);
        return createdMaintenanceResponse;
    }
}
