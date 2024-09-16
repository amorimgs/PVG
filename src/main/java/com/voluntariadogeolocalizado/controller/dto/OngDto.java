package com.voluntariadogeolocalizado.controller.dto;

import com.voluntariadogeolocalizado.entity.Ong;
import com.voluntariadogeolocalizado.entity.Opportunity;
import java.util.List;

public record OngDto(Long id, String name, String email, String description,
                     List<Opportunity> opportunities) {

  public static OngDto fromEntity(Ong ong) {
    return new OngDto(
        ong.getId(),
        ong.getName(),
        ong.getEmail(),
        ong.getDescription(),
        ong.getOpportunities()
    );
  }
}
