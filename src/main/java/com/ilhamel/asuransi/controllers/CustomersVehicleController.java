package com.ilhamel.asuransi.controllers;

import com.ilhamel.asuransi.dtos.customersVehicle.CustomersVehicleHeaderDto;
import com.ilhamel.asuransi.dtos.customersVehicle.UpsertCustomersVehicleDto;
import com.ilhamel.asuransi.rest.RestResponse;
import com.ilhamel.asuransi.services.CustomersVehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicles")
public class CustomersVehicleController {

    @Autowired
    private CustomersVehicleServices customersVehicleServices;

    @GetMapping
    public ResponseEntity<RestResponse<List<CustomersVehicleHeaderDto>>> findAll(){
        return new ResponseEntity<>(
                new RestResponse<>(customersVehicleServices.findAll(),
                        "Data ditemukan",
                        HttpStatus.OK.value()
                ),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<RestResponse<CustomersVehicleHeaderDto>> insertNewCustomersVehicle(@RequestParam String nasabahId, @RequestBody UpsertCustomersVehicleDto newCustomersVehicle){
        return new ResponseEntity<>(
                new RestResponse<>(customersVehicleServices.insertCustomersVehicle(nasabahId ,newCustomersVehicle),
                        "Customers Vehicle berhasil ditambahkan",
                        HttpStatus.CREATED.value()),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<RestResponse<CustomersVehicleHeaderDto>> updateCustomersVehicle(@RequestParam String vehicleId, @RequestBody UpsertCustomersVehicleDto newCustomersVehicle){
        return new ResponseEntity<>(
                new RestResponse<>(customersVehicleServices.updateCustomersVehicle(vehicleId, newCustomersVehicle),
                        "Customers Vehicle berhasil diubah",
                        HttpStatus.ACCEPTED.value()),
                HttpStatus.ACCEPTED
        );
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<List<CustomersVehicleHeaderDto>>> deleteCustomersVehicle(@RequestParam String vehicleId){
        return new ResponseEntity<>(
                new RestResponse<>(customersVehicleServices.deleteCustomersVehicle(vehicleId),
                        "Customers Vehicle berhasil dihapus",
                        HttpStatus.OK.value()),
                HttpStatus.OK
        );
    }

}
