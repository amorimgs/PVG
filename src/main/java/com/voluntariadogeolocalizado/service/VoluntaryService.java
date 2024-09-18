package com.voluntariadogeolocalizado.service;

import com.voluntariadogeolocalizado.controller.dto.VoluntaryCreationDto;
import com.voluntariadogeolocalizado.entity.Voluntary;
import com.voluntariadogeolocalizado.repository.VoluntaryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoluntaryService {

  private final VoluntaryRepository voluntaryRepository;

  @Autowired

  public VoluntaryService(VoluntaryRepository voluntaryRepository) {
    this.voluntaryRepository = voluntaryRepository;
  }

  public List<Voluntary> findAll() {
    return voluntaryRepository.findAll();
  }

  public Voluntary findById(Long id) {
    return voluntaryRepository.findById(id).orElseThrow();
  }

  public Voluntary createdVoluntary(Voluntary voluntary) {
    return voluntaryRepository.save(voluntary);
  }

  public Voluntary updateVoluntary(Long id, VoluntaryCreationDto voluntaryCreationDto) {
    Voluntary voluntary = findById(id);

    voluntary.setName(voluntaryCreationDto.name());
    voluntary.setEmail(voluntaryCreationDto.email());
    voluntary.setBirthday(voluntaryCreationDto.birthday());

    return voluntaryRepository.save(voluntary);
  }

  public Voluntary removeVoluntary(Long id) {

    Voluntary voluntary = findById(id);

    voluntaryRepository.delete(voluntary);

    return voluntary;
  }
}
