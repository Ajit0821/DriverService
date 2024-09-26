package com.driver.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "driver_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long driverId;
    @Column(name = "driver_name")
    @NotNull
    @Size(min = 4,max=10,message = "Driver name must be between 4 to 10")
    private String driverName;
    @Column(name="contact_number")
    @NotNull
    @Size(min=10 ,max=10, message = "Contact number must be of size 10")
    private  String contactNumber;
    @NotNull
    private String vechileDetails;
    @NotNull
    private  String licenseInformation;
    @Min(1)
    @Max(5)
    private  Integer  ratings;
    @NotNull
    private boolean availability_Status;
    @NotNull
    private String driverCurrentLocation;
}
