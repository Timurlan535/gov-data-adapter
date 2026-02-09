package com.citizen.service.adapter.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="citizens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String taxId;
    private String firstName;
    private String lastName;
    private Double monthlyIncome;
    private boolean isInsured;
}
