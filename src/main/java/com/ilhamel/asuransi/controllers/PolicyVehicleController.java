package com.ilhamel.asuransi.controllers;

import com.ilhamel.asuransi.dtos.policyVehicle.PolicyVehicleHeaderDto;
import com.ilhamel.asuransi.dtos.policyVehicle.UpsertPolicyVehicleDto;
import com.ilhamel.asuransi.rest.RestResponse;
import com.ilhamel.asuransi.services.PolicyVehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("policyvehicle")
public class PolicyVehicleController {

    @Autowired
    private PolicyVehicleServices policyVehicleServices;

    @GetMapping
    public ResponseEntity<RestResponse<List<PolicyVehicleHeaderDto>>> findAll(){
        return new ResponseEntity<>(
                new RestResponse<>(policyVehicleServices.findAll(),
                        "Data ditemukan",
                        HttpStatus.OK.value()
                ),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<RestResponse<List<PolicyVehicleHeaderDto>>> insertPolicyVehicle(@RequestBody UpsertPolicyVehicleDto newPolicyVehicle){
        return new ResponseEntity<>(
                new RestResponse<>(policyVehicleServices.insertPolicyVehicle(newPolicyVehicle),
                        "Policy Vehicle berhasil ditambahkan",
                        HttpStatus.CREATED.value()),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<RestResponse<PolicyVehicleHeaderDto>> updatePolicyVehicle(@RequestParam Integer policyId, @RequestBody UpsertPolicyVehicleDto updatedPolicyVehicle){
        return new ResponseEntity<>(
                new RestResponse<>(policyVehicleServices.updatePolicyVehicle(policyId,updatedPolicyVehicle),
                        "Policy Vehicle berhasil diupdate",
                        HttpStatus.OK.value()),
                HttpStatus.OK
        );
    }


}
