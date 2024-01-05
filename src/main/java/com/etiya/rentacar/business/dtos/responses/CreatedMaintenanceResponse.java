package com.etiya.rentacar.business.dtos.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatedMaintenanceResponse {
    private int id;

    private int carId;
    private LocalDateTime dateSent;

    private LocalDateTime createdDate;


}
