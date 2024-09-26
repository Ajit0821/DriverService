package com.driver.service.service;

import com.driver.service.gloabal.Exception.ApiException;
import com.driver.service.model.DriverDetails;
import com.driver.service.payload.DriversDetailsDto;
import com.driver.service.payload.DriversDetailsResponse;

public interface DriverDetailsService {

    DriversDetailsResponse getAllDetails() throws ApiException;


    DriversDetailsDto getDriverDetailsById(Long driverId);

    DriversDetailsDto saveDriversDetails(DriverDetails driverDetails);

    DriversDetailsDto deleteDriverDetailsById(Long driverId);

    DriversDetailsDto updateDriverDetails(DriverDetails driversDetails, Long driverId);
}
