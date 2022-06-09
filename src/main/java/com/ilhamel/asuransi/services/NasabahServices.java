package com.ilhamel.asuransi.services;

import com.ilhamel.asuransi.dtos.nasabah.NasabahHeaderDto;
import com.ilhamel.asuransi.dtos.nasabah.UpsertNasabahDto;
import com.ilhamel.asuransi.models.Nasabah;
import com.ilhamel.asuransi.models.Prospect;
import com.ilhamel.asuransi.repositories.NasabahRepository;
import com.ilhamel.asuransi.repositories.ProspectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

@Service
public class NasabahServices {

    private NasabahRepository nasabahRepository;
    private ProspectRepository prospectRepository;

    @Autowired
    public NasabahServices(NasabahRepository nasabahRepository, ProspectRepository prospectRepository) {
        this.nasabahRepository = nasabahRepository;
        this.prospectRepository = prospectRepository;
    }

    public List<NasabahHeaderDto> findAll() {

        return NasabahHeaderDto.toList(nasabahRepository.findAll());
    }


    public NasabahHeaderDto insertNasabah(Integer prospectId,UpsertNasabahDto newNasabah) {
        Prospect prospect = prospectRepository.findById(prospectId).orElseThrow(() -> new EntityNotFoundException("Prospect not found"));
        Nasabah data = newNasabah.toModel(newNasabahId(prospect), prospect);
        return NasabahHeaderDto.set(nasabahRepository.save(data));
    }

    private String newNasabahId(Prospect prospect) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/yyyy/");
        return LocalDate.now().format(formatter)+prospect.getId();
    }

    public NasabahHeaderDto updateNasabah(String nasabahId, UpsertNasabahDto newData) {
        Nasabah data = nasabahRepository.findById(nasabahId).orElseThrow(() -> new EntityNotFoundException("Nasabah not found"));

        Stream.of(newData).forEach(field -> {
            if (field != null) {

                nasabahRepository.save(field.setValue(data));
            }
        });

        return NasabahHeaderDto.set(data);
    }


    public List<NasabahHeaderDto> deleteNasabah(String nasabahId) {
        Nasabah data = nasabahRepository.findById(nasabahId).orElseThrow(() -> new EntityNotFoundException("Nasabah not found"));
        try {
            nasabahRepository.delete(data);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Nasabah sudah diasuransikan");
        }
        return NasabahHeaderDto.toList(nasabahRepository.findAll());
    }
}
