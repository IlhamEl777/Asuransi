package com.ilhamel.asuransi.services;

import com.ilhamel.asuransi.dtos.prospect.ProspectHeaderDto;
import com.ilhamel.asuransi.dtos.prospect.UpsertProspectDto;
import com.ilhamel.asuransi.models.Prospect;
import com.ilhamel.asuransi.repositories.ProspectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProspectService {
    @Autowired
    private ProspectRepository prospectRepository;

    public List<ProspectHeaderDto> findAll() {
        return ProspectHeaderDto.toList(prospectRepository.findAll());
    }

    public ProspectHeaderDto insertProspect(UpsertProspectDto newProspect) {
        Prospect data = newProspect.toModel();
        prospectRepository.save(data);
        return ProspectHeaderDto.set(data);
    }


    public ProspectHeaderDto updateProspect(Integer id,UpsertProspectDto newData) {
        Prospect data = prospectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Prospect tidak ditemukan!"));
        data.setFirstName(newData.getFirstName());
        data.setLastName(newData.getLastName());
        data.setBirthDate(newData.getBirthDate());
        data.setBirthPlace(newData.getBirthPlace());
        data.setGender(newData.getGender());
        data.setJob(newData.getJob());
        prospectRepository.save(data);
        return ProspectHeaderDto.set(data);
    }

    public List<ProspectHeaderDto> deleteProspect(Integer id) {
        Prospect data = prospectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Prospect tidak ditemukan!"));
        prospectRepository.delete(data);
        return ProspectHeaderDto.toList(prospectRepository.findAll());
    }
}
