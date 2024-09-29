package com.voluntariadogeolocalizado.controller.dto;

import java.time.LocalDateTime;

public record OpportunityCreationDto(
    String title, String description, String location, LocalDateTime eventDate, String duration,
    String requirements, String category, Long ongId
) {

}
