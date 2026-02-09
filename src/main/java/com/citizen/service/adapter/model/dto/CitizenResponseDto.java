package com.citizen.service.adapter.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitizenResponseDto {
    private String taxId;
    private String firstName;
    private String lastName;
    private Double monthlyIncome;
    private boolean isInsured;
    private String statusMessage;
}

