package com.etiya.rentacar.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCarRequest {

    private int modelYear;

    private String plate;

    private double dailyPrice;

    private int modelId;
}

