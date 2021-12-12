package com.project.tharun.CompanyServiceApplication.exception;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyNotFoundException extends RuntimeException {
    private String message;
}
