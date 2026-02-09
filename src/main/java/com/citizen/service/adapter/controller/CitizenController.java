package com.citizen.service.adapter.controller;

import com.citizen.service.adapter.model.dto.CitizenResponseDto;
import com.citizen.service.adapter.service.CitizenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/citizens")
@RequiredArgsConstructor
@Tag(name = "Citizen Adapter", description = "Получение данных из госреестра")

public class CitizenController {
    private final CitizenService citizenService;
    @Operation(summary = "Найти гражданина по ИИН")
    @GetMapping("/{taxId}")
    public CitizenResponseDto getCitizens(@PathVariable String taxId) {
        return citizenService.getCitizenInfo(taxId);
    }
}
