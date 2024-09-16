package com.voluntariadogeolocalizado.service;

import com.voluntariadogeolocalizado.controller.dto.OngCreationDto;
import com.voluntariadogeolocalizado.entity.Ong;
import com.voluntariadogeolocalizado.repository.OngRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OngService {

  private final OngRepository ongRepository;

  @Autowired
  public OngService(OngRepository ongRepository) {
    this.ongRepository = ongRepository;
  }

  public List<Ong> findAll() {
    return ongRepository.findAll();
  }

  public Ong findById(Long id) {
    return ongRepository.findById(id).orElseThrow();
  }

  public Ong createdOng(Ong ong) {
    return ongRepository.save(ong);
  }

  public Ong updateOng(Long id, OngCreationDto ongCreationDto) {
    Ong ong = findById(id);

    ong.setName(ongCreationDto.name());
    ong.setEmail(ongCreationDto.email());
    ong.setDescription(ongCreationDto.description());

    return ongRepository.save(ong);
  }

  public Ong removeOng(Long id) {
    Ong ong = findById(id);
    ongRepository.delete(ong);

    return ong;
  }
}
