package com.voluntariadogeolocalizado.controller;

import com.voluntariadogeolocalizado.controller.dto.OngCreationDto;
import com.voluntariadogeolocalizado.controller.dto.OngDto;
import com.voluntariadogeolocalizado.entity.Ong;
import com.voluntariadogeolocalizado.service.OngService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ongs")
public class OngController {

  private final OngService ongService;

  @Autowired
  public OngController(OngService ongService) {
    this.ongService = ongService;
  }

  @GetMapping
  public List<OngDto> findAll() {
    return ongService.findAll().stream().map(OngDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public OngDto findById(@PathVariable Long id) {
    Ong ong = ongService.findById(id);

    return OngDto.fromEntity(ong);
  }

  @PostMapping
  public OngDto createdOng(@RequestBody OngCreationDto ongCreationDto) {
    Ong ong = new Ong();
    ong.setName(ongCreationDto.name());
    ong.setEmail(ongCreationDto.email());
    ong.setPassword(ongCreationDto.password());
    ong.setDescription(ongCreationDto.description());
    return OngDto.fromEntity(ongService.createdOng(ong));
  }

  @PutMapping("/{id}")
  public OngDto updateOng(@PathVariable Long id, @RequestBody OngCreationDto ongCreationDto) {
    return OngDto.fromEntity(ongService.updateOng(id, ongCreationDto));
  }

  @DeleteMapping("/{id}")
  public OngDto removeOng(@PathVariable Long id) {
    return OngDto.fromEntity(ongService.removeOng(id));
  }
}
