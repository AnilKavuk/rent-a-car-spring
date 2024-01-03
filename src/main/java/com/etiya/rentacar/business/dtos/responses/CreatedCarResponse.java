package com.etiya.rentacar.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatedCarResponse {
    private int id;

    private int modelYear;

    private String plate;

    private double dailyPrice;

    private int modelId;

    private LocalDateTime createdDate;
}
