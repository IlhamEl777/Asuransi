package com.ilhamel.asuransi.controllers;

import com.ilhamel.asuransi.dtos.nasabah.NasabahHeaderDto;
import com.ilhamel.asuransi.dtos.nasabah.UpsertNasabahDto;
import com.ilhamel.asuransi.rest.RestResponse;
import com.ilhamel.asuransi.services.NasabahServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nasabah")
public class NasabahController {

    @Autowired
    private NasabahServices nasabahServices;

    @GetMapping
    public ResponseEntity<RestResponse<List<NasabahHeaderDto>>> findAll(){
        return new ResponseEntity<>(
                new RestResponse<>(nasabahServices.findAll(),
                        "Data ditemukan",
                        HttpStatus.OK.value()
                ),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<RestResponse<NasabahHeaderDto>> insertNewNasabah(@RequestParam Integer prospectId,@RequestBody UpsertNasabahDto newNasabah){
        return new ResponseEntity<>(
                new RestResponse<>(nasabahServices.insertNasabah(prospectId ,newNasabah),
                        "Nasabah berhasil ditambahkan",
                        HttpStatus.CREATED.value()),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<RestResponse<NasabahHeaderDto>> updateNasabah(@RequestParam String nasabahId,@RequestBody UpsertNasabahDto newNasabah){
        return new ResponseEntity<>(
                new RestResponse<>(nasabahServices.updateNasabah(nasabahId, newNasabah),
                        "Nasabah berhasil diubah",
                        HttpStatus.ACCEPTED.value()),
                HttpStatus.ACCEPTED
        );
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<List<NasabahHeaderDto>>> deleteNasabah(@RequestParam String nasabahId){
        return new ResponseEntity<>(
                new RestResponse<>(nasabahServices.deleteNasabah(nasabahId),
                        "Nasabah berhasil dihapus",
                        HttpStatus.OK.value()),
                HttpStatus.OK
        );
    }

}
