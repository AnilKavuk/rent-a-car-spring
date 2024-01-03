package com.etiya.rentacar.business.dtos.responses;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetAllBrandResponse {
    private int id;
    private String name;
    private LocalDateTime createdDate;
}
