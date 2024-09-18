package com.voluntariadogeolocalizado.controller.dto;

import com.voluntariadogeolocalizado.entity.Registration;
import com.voluntariadogeolocalizado.entity.Voluntary;
import java.time.LocalDate;
import java.util.List;

public record VoluntaryDto(String name, String email, LocalDate birthday,
                           List<Registration> registrations) {

  public static VoluntaryDto fromEntity(Voluntary voluntary) {
    return new VoluntaryDto(
        voluntary.getName(),
        voluntary.getEmail(),
        voluntary.getBirthday(),
        voluntary.getRegistrations()
    );
  }
}
