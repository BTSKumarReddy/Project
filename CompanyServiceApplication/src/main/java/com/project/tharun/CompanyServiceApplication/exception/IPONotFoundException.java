package com.project.tharun.CompanyServiceApplication.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IPONotFoundException extends RuntimeException{
    private String message;
}
