package com.etiya.rentacar.api.controller;

import com.etiya.rentacar.business.abstracts.MaintenanceService;
import com.etiya.rentacar.business.dtos.requests.CreateMaintenanceRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedMaintenanceResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/maintenances")
public class MaintenancesController {
    private MaintenanceService maintenanceService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private CreatedMaintenanceResponse add(@Valid @RequestBody CreateMaintenanceRequest createMaintenanceRequest){
        return maintenanceService.add(createMaintenanceRequest);
    }
}
