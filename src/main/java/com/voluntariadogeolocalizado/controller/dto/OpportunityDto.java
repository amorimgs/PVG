package com.voluntariadogeolocalizado.controller.dto;

import com.voluntariadogeolocalizado.entity.Ong;
import com.voluntariadogeolocalizado.entity.Opportunity;
import com.voluntariadogeolocalizado.entity.Registration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public record OpportunityDto(String title, String description, String location,
                             LocalDateTime eventDate, String duration,
                             String requirements, String category, OngDto ong,
                             List<Registration> registrations) {

  public static OpportunityDto fromEntity(Opportunity opportunity) {
    return new OpportunityDto(
        opportunity.getTitle(),
        opportunity.getDescription(),
        opportunity.getLocation(),
        opportunity.getEventDate(),
        opportunity.getDuration(),
        opportunity.getRequirements(),
        opportunity.getCategory(),
        OngDto.fromEntity(opportunity.getOng()),
        opportunity.getRegistrations()
    );
  }
}
