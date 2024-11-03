package com.driver.service.controller;

import com.driver.service.gloabal.Exception.ApiException;
import com.driver.service.model.DriverDetails;
import com.driver.service.payload.DriversDetailsDto;
import com.driver.service.payload.DriversDetailsResponse;
import com.driver.service.repository.DriverDetailsRepository;
import com.driver.service.service.DriverDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class DriverDetailsController {
    private final DriverDetailsService driverDetailsService;

    public DriverDetailsController (DriverDetailsService driverDetailsService){
        this.driverDetailsService=driverDetailsService;
    }

    @GetMapping("/drivers-details")
    public ResponseEntity<DriversDetailsResponse> getAllDriversDetails() throws ApiException {
        DriversDetailsResponse  response=driverDetailsService.getAllDetails();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/drivers-details/{driverId}")
    public ResponseEntity<DriversDetailsDto> getDriverDetails(@PathVariable Long driverId)  {
        DriversDetailsDto details = driverDetailsService.getDriverDetailsById(driverId);
        return new ResponseEntity<>(details,HttpStatus.OK);
    }
    @PostMapping("/drivers-details")
    public ResponseEntity<DriversDetailsDto> createCategory(@Valid @RequestBody DriverDetails driverDetails){
        DriversDetailsDto savedDetails=driverDetailsService.saveDriversDetails(driverDetails);
        return new ResponseEntity<>(savedDetails, HttpStatus.CREATED);
    }
        @DeleteMapping("/drivers-details/{driverId}")
        public ResponseEntity<DriversDetailsDto> deleteDriverDetails(@PathVariable Long driverId){
            DriversDetailsDto DriversDetailsDto = driverDetailsService.deleteDriverDetailsById(driverId);
            return (new ResponseEntity<>(DriversDetailsDto, HttpStatus.OK));
        }
    @PutMapping("/drivers-details/{driverId}")
    public ResponseEntity<DriversDetailsDto> updateCategory(@RequestBody DriverDetails driversDetails,
                                                      @PathVariable Long driverId){
        DriversDetailsDto updatedDetails = driverDetailsService.updateDriverDetails(driversDetails, driverId);
            return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
    }
}
