package com.ilhamel.asuransi.repositories;

import com.ilhamel.asuransi.models.PolicyLife;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyLifeRepository extends JpaRepository<PolicyLife, Integer> {
}