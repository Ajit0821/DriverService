package com.driver.service.repository;

import com.driver.service.model.DriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverDetailsRepository extends JpaRepository<DriverDetails,Long> {
}
