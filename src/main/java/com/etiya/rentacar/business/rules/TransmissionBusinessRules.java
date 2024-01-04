package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.business.messages.TransmissionMessages;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.etiya.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class TransmissionBusinessRules {
    TransmissionRepository transmissionRepository;

    public void TransmissionNameCanNotBeDuplicated(String transmissionName){
        Optional<Transmission> transmission=transmissionRepository.findByNameIgnoreCase(transmissionName);

        if(transmission.isPresent()){
            throw  new BusinessException(TransmissionMessages.TransmissionNameAlreadyExists);
        }
    }
}
