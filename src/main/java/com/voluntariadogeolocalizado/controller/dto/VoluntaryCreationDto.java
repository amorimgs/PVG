package com.voluntariadogeolocalizado.controller.dto;

import java.time.LocalDate;

public record VoluntaryCreationDto(String name, String email, String password, LocalDate birthday) {

}

