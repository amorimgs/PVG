package com.voluntariadogeolocalizado.controller;

import com.voluntariadogeolocalizado.controller.dto.VoluntaryCreationDto;
import com.voluntariadogeolocalizado.controller.dto.VoluntaryDto;
import com.voluntariadogeolocalizado.entity.Voluntary;
import com.voluntariadogeolocalizado.service.VoluntaryService;
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
@RequestMapping("/voluntaries")
public class VoluntaryController {

  private final VoluntaryService voluntaryService;

  @Autowired
  public VoluntaryController(VoluntaryService voluntaryService) {
    this.voluntaryService = voluntaryService;
  }

  @GetMapping
  public List<VoluntaryDto> findAll() {
    return voluntaryService.findAll().stream().map(VoluntaryDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public VoluntaryDto findById(@PathVariable Long id) {
    Voluntary voluntary = voluntaryService.findById(id);

    return VoluntaryDto.fromEntity(voluntary);
  }

  @PostMapping
  public VoluntaryDto createdVoluntary(@RequestBody VoluntaryCreationDto voluntaryCreationDto) {
    Voluntary voluntary = new Voluntary();
    voluntary.setName(voluntaryCreationDto.name());
    voluntary.setEmail(voluntaryCreationDto.email());
    voluntary.setPassword(voluntaryCreationDto.password());
    voluntary.setBirthday(voluntaryCreationDto.birthday());
    return VoluntaryDto.fromEntity(voluntaryService.createdVoluntary(voluntary));
  }

  @PutMapping("/{id}")
  public VoluntaryDto updateVoluntary(@PathVariable Long id,
      @RequestBody VoluntaryCreationDto voluntaryCreationDto) {
    return VoluntaryDto.fromEntity(voluntaryService.updateVoluntary(id, voluntaryCreationDto));
  }

  @DeleteMapping("/{id}")
  public VoluntaryDto removeVoluntary(@PathVariable Long id) {
    return VoluntaryDto.fromEntity(voluntaryService.removeVoluntary(id));
  }
}
