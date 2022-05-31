package com.ilhamel.asuransi.services;

import com.ilhamel.asuransi.dtos.policLife.PolicyLifeHeaderDto;
import com.ilhamel.asuransi.dtos.policLife.UpsertPolicyLifeDto;
import com.ilhamel.asuransi.models.Nasabah;
import com.ilhamel.asuransi.models.PolicyLife;
import com.ilhamel.asuransi.models.Product;
import com.ilhamel.asuransi.repositories.NasabahRepository;
import com.ilhamel.asuransi.repositories.PolicyLifeRepository;
import com.ilhamel.asuransi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PolicyLifeServices {

    private PolicyLifeRepository policyLifeRepository;
    private NasabahRepository nasabahRepository;
    private ProductRepository productRepository;

    @Autowired
    public PolicyLifeServices(PolicyLifeRepository policyLifeRepository, NasabahRepository nasabahRepository, ProductRepository productRepository) {
        this.policyLifeRepository = policyLifeRepository;
        this.nasabahRepository = nasabahRepository;
        this.productRepository = productRepository;
    }

    public List<PolicyLifeHeaderDto> findAll() {
        return PolicyLifeHeaderDto.toList(policyLifeRepository.findAll());
    }

    public List<PolicyLifeHeaderDto> insertPolicyLife(UpsertPolicyLifeDto newPolicyLife) {
        Nasabah nasabah = nasabahRepository.findById(newPolicyLife.getNasabahId()).orElseThrow(() -> new EntityNotFoundException("Nasabah not found"));
        Nasabah insuredNasabah = nasabahRepository.findById(newPolicyLife.getInsuredNasabahId()).orElseThrow(() -> new EntityNotFoundException("Insured Nasabah not found"));
        Product product = productRepository.findById(newPolicyLife.getProductId()).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        Stream.of(newPolicyLife).forEach(field -> {
            if (field != null) {
                policyLifeRepository.save(newPolicyLife.toModel(nasabah, insuredNasabah, product));
            }
        });
        return findAll();
    }

    public PolicyLifeHeaderDto updatePolicyLife(Integer id, UpsertPolicyLifeDto newData) {
        PolicyLife data = policyLifeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Policy Life not found"));
        Product product = productRepository.findById(newData.getProductId()).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        Nasabah nasabah = nasabahRepository.findById(newData.getNasabahId()).orElseThrow(() -> new EntityNotFoundException("Nasabah not found"));
        Nasabah insuredNasabah = nasabahRepository.findById(newData.getInsuredNasabahId()).orElseThrow(() -> new EntityNotFoundException("Insured Nasabah not found"));

        Stream.of(newData).forEach(field -> {
            if (field != null) {
                field.setValue(data, product, nasabah, insuredNasabah);
                policyLifeRepository.save(data);
            }
        });
        return PolicyLifeHeaderDto.set(data);
    }

    public List<PolicyLifeHeaderDto> deletePolicyLife(Integer policyId) {
        PolicyLife data = policyLifeRepository.findById(policyId).orElseThrow(() -> new EntityNotFoundException("Policy Life not found"));
        policyLifeRepository.delete(data);
        return findAll();
    }
}
