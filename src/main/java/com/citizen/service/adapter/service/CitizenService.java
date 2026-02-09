package com.citizen.service.adapter.service;

import com.citizen.service.adapter.exception.CitizenNotFoundException;
import com.citizen.service.adapter.model.dto.CitizenResponseDto;
import com.citizen.service.adapter.model.entity.Citizen;
import com.citizen.service.adapter.repository.CitizenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CitizenService {
    private final CitizenRepository citizenRepository;
    public CitizenResponseDto getCitizenInfo(String taxId){
        log.info("===>Поиск гражданина по ИИН: {}",taxId);
        Citizen citizen = citizenRepository.findByTaxId(taxId)
                .orElseThrow(()-> {
                    log.error("xxx Гражданин с ИИН {} не найден", taxId);
                    return new CitizenNotFoundException("Гражданин не найден");
                });
            log.info("<== Данные найдены для: {} {}", citizen.getFirstName(), citizen.getLastName());
            return CitizenResponseDto.builder()
                    .taxId(citizen.getTaxId())
                    .firstName(citizen.getFirstName())
                    .lastName(citizen.getLastName())
                    .monthlyIncome(citizen.getMonthlyIncome())
                    .isInsured(citizen.isInsured())
                    .statusMessage("Success")
                    .build();

    }
}
