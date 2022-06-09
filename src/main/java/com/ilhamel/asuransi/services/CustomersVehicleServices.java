package com.ilhamel.asuransi.services;

import com.ilhamel.asuransi.dtos.customersVehicle.CustomersVehicleHeaderDto;
import com.ilhamel.asuransi.dtos.customersVehicle.UpsertCustomersVehicleDto;
import com.ilhamel.asuransi.models.CustomersVehicle;
import com.ilhamel.asuransi.models.Nasabah;
import com.ilhamel.asuransi.repositories.CustomersVehicleRepository;
import com.ilhamel.asuransi.repositories.NasabahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CustomersVehicleServices {

    private CustomersVehicleRepository customersVehicleRepository;
    private NasabahRepository nasabahRepository;

    @Autowired
    public CustomersVehicleServices(CustomersVehicleRepository customersVehicleRepository, NasabahRepository nasabahRepository) {
        this.customersVehicleRepository = customersVehicleRepository;
        this.nasabahRepository = nasabahRepository;
    }

    public List<CustomersVehicleHeaderDto> findAll() {
        return CustomersVehicleHeaderDto.toList(customersVehicleRepository.findAll());
    }


    public CustomersVehicleHeaderDto insertCustomersVehicle(String nasabahId, UpsertCustomersVehicleDto newCustomersVehicle) {
        Nasabah nasabah = nasabahRepository.findById(nasabahId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nasabah not found"));
        customersVehicleRepository.findById(newCustomersVehicle.getVehiclePlate()).ifPresent(data -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vehicle already exist");
        });

        Stream.of(newCustomersVehicle).forEach(field -> {
            if (field != null) {
                customersVehicleRepository.save(newCustomersVehicle.toModel(nasabah));
            }
        });
        return CustomersVehicleHeaderDto.set(customersVehicleRepository.getReferenceById(newCustomersVehicle.getVehiclePlate()));
    }


    public CustomersVehicleHeaderDto updateCustomersVehicle(String customersVehicleId, UpsertCustomersVehicleDto newCustomersVehicle) {
        CustomersVehicle data = customersVehicleRepository.findById(customersVehicleId).orElseThrow(() -> new EntityNotFoundException("CustomersVehicle not found"));

        Stream.of(newCustomersVehicle).forEach(field -> {
            if (field != null) {
                customersVehicleRepository.save(field.setValue(data));
            }
        });

        return CustomersVehicleHeaderDto.set(data);
    }

    public List<CustomersVehicleHeaderDto> deleteCustomersVehicle(String vehicleId) {
        customersVehicleRepository.deleteById(vehicleId);
        return CustomersVehicleHeaderDto.toList(customersVehicleRepository.findAll());
    }
}
