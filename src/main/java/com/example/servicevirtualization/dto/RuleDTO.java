package com.example.servicevirtualization.dto;

import lombok.Data;

@Data
public class RuleDTO {
    private Long id;
    private String name;
    private String description;
    private Integer ruleOrder;  // Kuralların sıralamasını gösterir
}