package com.project.tharun.CompanyServiceApplication.exception;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String errorMessage;
    private int statusCode;
    private long timeHappened;
}
