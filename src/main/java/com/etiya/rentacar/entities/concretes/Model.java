package com.etiya.rentacar.entities.concretes;

import com.etiya.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "models")
public class Model extends BaseEntity<Integer> {
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="brandId")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "fuelId")
    private  Fuel fuel;

    @ManyToOne
    @JoinColumn(name = "transmissionId")
    private Transmission transmission;
}
