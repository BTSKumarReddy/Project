package com.project.tharun.SectorServiceApplication.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectorNotFoundException extends RuntimeException {
    private String message;
}
