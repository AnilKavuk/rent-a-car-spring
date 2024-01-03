package com.etiya.rentacar.business.dtos.requests;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateBrandRequest {
    @NotNull
    @Size(min=2,max=30)
    private String name;
}
