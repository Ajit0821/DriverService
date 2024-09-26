package com.driver.service.service;

import com.driver.service.gloabal.Exception.ApiException;
import com.driver.service.gloabal.Exception.DataNotFoundException;
import com.driver.service.model.DriverDetails;
import com.driver.service.payload.DriversDetailsDto;
import com.driver.service.payload.DriversDetailsResponse;
import com.driver.service.repository.DriverDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverDetailsServiceImpl implements DriverDetailsService{
    private final  DriverDetailsRepository driverDetailsRepository;
    private final ModelMapper modelMapper;

    public DriverDetailsServiceImpl(DriverDetailsRepository driverDetailsRepository,ModelMapper modelMapper){
        this.driverDetailsRepository=driverDetailsRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public DriversDetailsResponse getAllDetails() throws ApiException {
        Optional<List<DriverDetails>> optionalDriverDetails = Optional.of(driverDetailsRepository.findAll());
        List<DriversDetailsDto> driversDetailsDtoList=optionalDriverDetails
                .filter(driverDetailsList -> !driverDetailsList.isEmpty())
                .orElseThrow(()->new ApiException("Drivers Details are not present"))
                .stream()
                .map(driverDetails -> modelMapper.map(driverDetails,DriversDetailsDto.class)).toList();
        DriversDetailsResponse driversDetailsResponse=new DriversDetailsResponse();
        driversDetailsResponse.setDriverDetailsResponse(driversDetailsDtoList);
        return driversDetailsResponse;
    }

    @Override
    public DriversDetailsDto getDriverDetailsById(Long driverId) {
       Optional<DriverDetails> optionalDriverDetails = Optional.ofNullable(driverDetailsRepository.findById(driverId)
               .orElseThrow(() -> new DataNotFoundException
                       (String.format("Driver Details with ID %d is not present", driverId))));
        return modelMapper.map(optionalDriverDetails,DriversDetailsDto.class);
    }

    @Override
    public DriversDetailsDto saveDriversDetails(DriverDetails driverDetails) {
        DriverDetails details=driverDetailsRepository.save(driverDetails);
        DriversDetailsDto driversDetailsDto=new DriversDetailsDto();
        driversDetailsDto.setDriverId(details.getDriverId());
        driversDetailsDto.setDriverName(driverDetails.getDriverName());
        driversDetailsDto.setVechileDetails(driverDetails.getVechileDetails());
        driversDetailsDto.setContactNumber(driverDetails.getContactNumber());
        driversDetailsDto.setLicenseInformation(driverDetails.getLicenseInformation());
        driversDetailsDto.setAvailability_Status(driverDetails.isAvailability_Status());
        driversDetailsDto.setDriverCurrentLocation(driverDetails.getDriverCurrentLocation());
        return driversDetailsDto;
    }

    @Override
    public DriversDetailsDto deleteDriverDetailsById(Long driverId) {
        Optional<DriverDetails> optionalDriverDetails = Optional.ofNullable(driverDetailsRepository.findById(driverId)
                .orElseThrow(() -> new DataNotFoundException
                        (String.format("Driver Details with ID %d is not present", driverId))));
        driverDetailsRepository.deleteById(driverId);
        return modelMapper.map(optionalDriverDetails,DriversDetailsDto.class);
    }

    @Override
    public DriversDetailsDto updateDriverDetails(DriverDetails driversDetails, Long driverId) {
        Optional<DriverDetails> optionalDriverDetails = Optional.ofNullable(driverDetailsRepository.findById(driverId)
                .orElseThrow(() -> new DataNotFoundException
                        (String.format("Driver Details with ID %d is not present", driverId))));
        optionalDriverDetails.get().setDriverName(driversDetails.getDriverName());
        optionalDriverDetails.get().setVechileDetails(driversDetails.getVechileDetails());
        optionalDriverDetails.get().setLicenseInformation(driversDetails.getLicenseInformation());
        optionalDriverDetails.get().setContactNumber(driversDetails.getContactNumber());
        optionalDriverDetails.get().setAvailability_Status(driversDetails.isAvailability_Status());
        optionalDriverDetails.get().setDriverCurrentLocation(driversDetails.getDriverCurrentLocation());
        driverDetailsRepository.save(optionalDriverDetails.get());
        DriversDetailsDto driversDetailsDto= new DriversDetailsDto();
        driversDetailsDto.setDriverId(optionalDriverDetails.get().getDriverId());
        driversDetailsDto.setDriverName(optionalDriverDetails.get().getDriverName());
        driversDetailsDto.setVechileDetails(optionalDriverDetails.get().getVechileDetails());
        driversDetailsDto.setContactNumber(optionalDriverDetails.get().getContactNumber());
        driversDetailsDto.setLicenseInformation(optionalDriverDetails.get().getLicenseInformation());
        driversDetailsDto.setAvailability_Status(optionalDriverDetails.get().isAvailability_Status());
        driversDetailsDto.setDriverCurrentLocation(optionalDriverDetails.get().getDriverCurrentLocation());
        return driversDetailsDto;
    }
}
