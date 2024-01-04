package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.CreateTransmissionRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedTransmissionResponse;
import com.etiya.rentacar.business.dtos.responses.GetAllTransmissionResponse;

import java.util.List;

public interface    TransmissionService {
    CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest);

    List<GetAllTransmissionResponse> getAll();
}
