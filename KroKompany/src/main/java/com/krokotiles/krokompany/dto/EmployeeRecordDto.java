package com.krokotiles.krokompany.dto;

import jakarta.validation.constraints.NotBlank;

public record EmployeeRecordDto(@NotBlank String name,
                                @NotBlank String role) {
}
