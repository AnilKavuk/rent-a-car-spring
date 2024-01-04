package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.TransmissionService;
import com.etiya.rentacar.business.dtos.requests.CreateTransmissionRequest;
import com.etiya.rentacar.business.dtos.responses.CreatedTransmissionResponse;
import com.etiya.rentacar.business.dtos.responses.GetAllTransmissionResponse;
import com.etiya.rentacar.business.rules.TransmissionBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.etiya.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {
    private TransmissionRepository transmissionRepository;
    private ModelMapperService modelMapperService;
    private TransmissionBusinessRules transmissionBusinessRules;
    @Override
    public CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest) {
        transmissionBusinessRules.TransmissionNameCanNotBeDuplicated(createTransmissionRequest.getName());
        Transmission transmission=this.modelMapperService.forRequest().map(createTransmissionRequest,Transmission.class);

        transmission.setCreatedDate(LocalDateTime.now());

        Transmission createdTransmission=transmissionRepository.save(transmission);

        CreatedTransmissionResponse createdTransmissionResponse=this.modelMapperService.forResponse().map(createdTransmission,CreatedTransmissionResponse.class);

        return createdTransmissionResponse;
    }

    @Override
    public List<GetAllTransmissionResponse> getAll() {
        var result= transmissionRepository.findAll();

        List<GetAllTransmissionResponse> response = result.stream().map(transmission -> this.modelMapperService.forResponse()
                .map(transmission, GetAllTransmissionResponse.class)).collect(Collectors.toList());
        return response;
    }
}
