package com.driver.service.gloabal.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataNotFoundException extends RuntimeException{
    private String message;
}
