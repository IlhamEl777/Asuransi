package com.ilhamel.asuransi.services;

import com.ilhamel.asuransi.dtos.policyVehicle.PolicyVehicleHeaderDto;
import com.ilhamel.asuransi.dtos.policyVehicle.UpsertPolicyVehicleDto;
import com.ilhamel.asuransi.models.CustomersVehicle;
import com.ilhamel.asuransi.models.PolicyVehicle;
import com.ilhamel.asuransi.models.Product;
import com.ilhamel.asuransi.repositories.CustomersVehicleRepository;
import com.ilhamel.asuransi.repositories.PolicyVehicleRepository;
import com.ilhamel.asuransi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PolicyVehicleServices {

    private PolicyVehicleRepository policyVehicleRepository;
    private ProductRepository productRepository;
    private CustomersVehicleRepository customersVehicleRepository;

    @Autowired
    public PolicyVehicleServices(PolicyVehicleRepository policyVehicleRepository, ProductRepository productRepository, CustomersVehicleRepository customersVehicleRepository) {
        this.policyVehicleRepository = policyVehicleRepository;
        this.productRepository = productRepository;
        this.customersVehicleRepository = customersVehicleRepository;
    }

    public List<PolicyVehicleHeaderDto> findAll() {
            return PolicyVehicleHeaderDto.toList(policyVehicleRepository.findAll());
    }

    public List<PolicyVehicleHeaderDto> insertPolicyVehicle(UpsertPolicyVehicleDto newPolicyVehicle) {
        Product product = productRepository.findById(newPolicyVehicle.getProductId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        CustomersVehicle customersVehicle = customersVehicleRepository.findById(newPolicyVehicle.getVehiclePlateId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customers Vehicle not found"));

        Stream.of(newPolicyVehicle).forEach(field -> {
            if (field != null) {
                policyVehicleRepository.save(newPolicyVehicle.toModel(product, customersVehicle));
            }
        });
        return findAll();
    }


    public PolicyVehicleHeaderDto updatePolicyVehicle(Integer policyId, UpsertPolicyVehicleDto updatedPolicyVehicle) {
        CustomersVehicle data = customersVehicleRepository.findById(updatedPolicyVehicle.getVehiclePlateId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customers Vehicle not found"));
        PolicyVehicle policyVehicle = policyVehicleRepository.findById(policyId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Policy Vehicle not found"));
        Product product = productRepository.findById(updatedPolicyVehicle.getProductId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,  "Product not found"));

        Stream.of(updatedPolicyVehicle).forEach(field -> {
            if (field != null) {
                policyVehicleRepository.save(field.setValue(data, policyVehicle, product));
            }
        });

        return PolicyVehicleHeaderDto.set(policyVehicle);
    }

}
