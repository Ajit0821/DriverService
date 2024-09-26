package com.driver.service.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriversDetailsDto {
    private Long driverId;
    private String driverName;
    private  String contactNumber;
    private String vechileDetails;
    private  String licenseInformation;
    private  Integer  ratings;
    private boolean availability_Status;
    private String driverCurrentLocation;
}
