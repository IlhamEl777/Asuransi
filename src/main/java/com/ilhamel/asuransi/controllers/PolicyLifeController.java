package com.ilhamel.asuransi.controllers;

import com.ilhamel.asuransi.dtos.policLife.PolicyLifeHeaderDto;
import com.ilhamel.asuransi.dtos.policLife.UpsertPolicyLifeDto;
import com.ilhamel.asuransi.rest.RestResponse;
import com.ilhamel.asuransi.services.PolicyLifeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("policylife")
public class PolicyLifeController {

    @Autowired
    private PolicyLifeServices policyLifeServices;

    @GetMapping
    public ResponseEntity<RestResponse<List<PolicyLifeHeaderDto>>> findAll(){
        return new ResponseEntity<>(
                new RestResponse<>(policyLifeServices.findAll(),
                        "Data ditemukan",
                        HttpStatus.OK.value()
                ),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<RestResponse<List<PolicyLifeHeaderDto>>> insertNewPolicyLife(@RequestBody UpsertPolicyLifeDto policyLifeHeaderDto){
        return new ResponseEntity<>(
                new RestResponse<>(policyLifeServices.insertPolicyLife(policyLifeHeaderDto),
                        "Data berhasil ditambahkan",
                        HttpStatus.CREATED.value()
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<RestResponse<PolicyLifeHeaderDto>> updatePolicyLife(@RequestParam Integer policyId,@RequestBody UpsertPolicyLifeDto policyLifeHeaderDto){
        return new ResponseEntity<>(
                new RestResponse<>(policyLifeServices.  updatePolicyLife(policyId, policyLifeHeaderDto),
                        "Data berhasil diubah",
                        HttpStatus.ACCEPTED.value()
                ),
                HttpStatus.ACCEPTED
        );
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<List<PolicyLifeHeaderDto>>> deletePolicyLife(@RequestParam Integer policyId){
        return new ResponseEntity<>(
                new RestResponse<>(policyLifeServices.deletePolicyLife(policyId),
                        "Data berhasil dihapus",
                        HttpStatus.OK.value()
                ),
                HttpStatus.OK
        );
    }

}
