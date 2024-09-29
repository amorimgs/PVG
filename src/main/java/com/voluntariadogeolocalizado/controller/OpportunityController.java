package com.voluntariadogeolocalizado.controller;

import com.voluntariadogeolocalizado.controller.dto.OpportunityCreationDto;
import com.voluntariadogeolocalizado.controller.dto.OpportunityDto;
import com.voluntariadogeolocalizado.entity.Opportunity;
import com.voluntariadogeolocalizado.service.OngService;
import com.voluntariadogeolocalizado.service.OpportunityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/opportunities")
public class OpportunityController {

  private final OpportunityService opportunityService;
  private final OngService ongService;

  @Autowired
  public OpportunityController(OpportunityService opportunityService, OngService ongService) {
    this.opportunityService = opportunityService;
    this.ongService = ongService;
  }

  @GetMapping
  public List<OpportunityDto> findAll() {
    return opportunityService.findAll().stream().map(OpportunityDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public OpportunityDto findById(@PathVariable Long id) {
    Opportunity opportunity = opportunityService.findById(id);

    return OpportunityDto.fromEntity(opportunity);
  }

  @PostMapping
  public OpportunityDto createdOpportunity(
      @RequestBody OpportunityCreationDto opportunityCreationDto) {
    Opportunity opportunity = new Opportunity();
    opportunity.setTitle(opportunityCreationDto.title());
    opportunity.setDescription(opportunityCreationDto.description());
    opportunity.setLocation(opportunityCreationDto.location());
    opportunity.setEventDate(opportunityCreationDto.eventDate());
    opportunity.setDuration(opportunityCreationDto.duration());
    opportunity.setRequirements(opportunityCreationDto.requirements());
    opportunity.setCategory(opportunityCreationDto.category());
    opportunity.setOng(ongService.findById(opportunityCreationDto.ongId()));

    return OpportunityDto.fromEntity(opportunityService.createdOpportunity(opportunity));
  }

  @PutMapping("/{id}")
  public OpportunityDto updateOpportunity(@PathVariable Long id,
      @RequestBody OpportunityCreationDto opportunityCreationDto) {
    return OpportunityDto.fromEntity(
        opportunityService.updateOpportunity(id, opportunityCreationDto));
  }

  @DeleteMapping("/{id}")
  public OpportunityDto removeOpportunity(@PathVariable Long id) {
    return OpportunityDto.fromEntity(opportunityService.removeOpportunity(id));
  }
}
