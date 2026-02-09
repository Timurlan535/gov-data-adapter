package com.citizen.service.adapter.repository;

import com.citizen.service.adapter.model.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
        //находим гражданина по ИИН
        Optional<Citizen> findByTaxId(String taxId);

}
