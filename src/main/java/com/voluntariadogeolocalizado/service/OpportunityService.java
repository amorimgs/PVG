package com.voluntariadogeolocalizado.service;

import com.voluntariadogeolocalizado.controller.dto.OpportunityCreationDto;
import com.voluntariadogeolocalizado.entity.Opportunity;
import com.voluntariadogeolocalizado.repository.OpportynityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpportunityService {

  private final OpportynityRepository opportynityRepository;

  @Autowired
  public OpportunityService(OpportynityRepository opportynityRepository) {
    this.opportynityRepository = opportynityRepository;
  }

  public List<Opportunity> findAll() {
    return opportynityRepository.findAll();
  }

  public Opportunity findById(Long id) {
    return opportynityRepository.findById(id).orElseThrow();
  }

  public Opportunity createdOpportunity(Opportunity opportunity) {
    return opportynityRepository.save(opportunity);
  }

  public Opportunity updateOpportunity(Long id, OpportunityCreationDto opportunityCreationDto) {
    Opportunity opportunity = findById(id);

    opportunity.setTitle(opportunityCreationDto.title());

    return opportynityRepository.save(opportunity);
  }

  public Opportunity removeOpportunity(Long id) {
    Opportunity opportunity = findById(id);
    opportynityRepository.delete(opportunity);

    return opportunity;
  }
}
