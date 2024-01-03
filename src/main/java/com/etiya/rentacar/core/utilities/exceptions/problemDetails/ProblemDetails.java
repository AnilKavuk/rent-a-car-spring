package com.etiya.rentacar.core.utilities.exceptions.problemDetails;

import lombok.*;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProblemDetails {
    // rfce standarts
    private String title;
    private String detail;
    private String Status;
    private String Type;

}
