package com.voluntariadogeolocalizado.repository;

import com.voluntariadogeolocalizado.entity.Registration;
import org.apache.juli.logging.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
