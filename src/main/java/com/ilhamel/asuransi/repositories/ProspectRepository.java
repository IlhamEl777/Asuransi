package com.ilhamel.asuransi.repositories;

import com.ilhamel.asuransi.models.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProspectRepository extends JpaRepository<Prospect, Integer> {
}