package com.ilhamel.asuransi.repositories;

import com.ilhamel.asuransi.models.Nasabah;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NasabahRepository extends JpaRepository<Nasabah, String> {
}