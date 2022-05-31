package com.ilhamel.asuransi.controllers;

import com.ilhamel.asuransi.dtos.prospect.ProspectHeaderDto;
import com.ilhamel.asuransi.dtos.prospect.UpsertProspectDto;
import com.ilhamel.asuransi.rest.RestResponse;
import com.ilhamel.asuransi.services.ProspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prospect")
public class ProspectController {

    @Autowired
    private ProspectService prospectService;

    @GetMapping
    public ResponseEntity<RestResponse<List<ProspectHeaderDto>>> findAll(){
        return new ResponseEntity<>(
                new RestResponse<>(prospectService.findAll(),
                        "Data ditemukan",
                        HttpStatus.OK.value()
                ),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<RestResponse<ProspectHeaderDto>> insertProspect(@RequestBody UpsertProspectDto newProspect){
        return new ResponseEntity<>(
                new RestResponse<>(prospectService.insertProspect(newProspect),
                        "Prospect berhasil ditambahkan",
                        HttpStatus.CREATED.value()),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<RestResponse<ProspectHeaderDto>> updateProspect(@RequestParam Integer id,@RequestBody UpsertProspectDto newProspect){
        return new ResponseEntity<>(
                new RestResponse<>(prospectService.updateProspect(id, newProspect),
                        "Prospect berhasil diubah",
                        HttpStatus.ACCEPTED.value()),
                HttpStatus.ACCEPTED
        );
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<List<ProspectHeaderDto>>> deleteProspect(@RequestParam Integer id){
        return new ResponseEntity<>(
                new RestResponse<>(prospectService.deleteProspect(id),
                        "Prospect berhasil dihapus",
                        HttpStatus.OK.value()),
                HttpStatus.OK
        );
    }




}