package com.voluntariadogeolocalizado.controller.dto;

import com.voluntariadogeolocalizado.entity.Ong;
import com.voluntariadogeolocalizado.entity.Opportunity;
import java.util.List;

public record OngWithOpportunitiesDto(Long id, String name, String email, String description,
                                      List<Opportunity> opportunities) {

  public static OngWithOpportunitiesDto fromEntity(Ong ong) {
    return new OngWithOpportunitiesDto(
        ong.getId(),
        ong.getName(),
        ong.getEmail(),
        ong.getDescription(),
        ong.getOpportunities()
    );
  }
}
