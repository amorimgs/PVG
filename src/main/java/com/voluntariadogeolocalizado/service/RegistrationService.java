package com.voluntariadogeolocalizado.service;

import com.voluntariadogeolocalizado.entity.Registration;
import com.voluntariadogeolocalizado.repository.RegistrationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

  private final RegistrationRepository registrationRepository;

  @Autowired
  public RegistrationService(RegistrationRepository registrationRepository) {
    this.registrationRepository = registrationRepository;
  }

  public List<Registration> findAll() {
    return registrationRepository.findAll();
  }

  public Registration findById(Long id) {
    return registrationRepository.findById(id).orElseThrow();
  }

  public Registration createdRegistration(Registration registration) {
    return registrationRepository.save(registration);
  }

  public Registration removeRegistration(Long id) {
    Registration registration = findById(id);
    registrationRepository.delete(registration);

    return registration;
  }
}
