package com.voluntariadogeolocalizado.controller;

import com.voluntariadogeolocalizado.entity.Voluntary;
import com.voluntariadogeolocalizado.repository.VoluntaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
public class TestController {

    private final VoluntaryRepository voluntaryRepository;

    @Autowired
    public TestController(VoluntaryRepository voluntaryRepository) {
        this.voluntaryRepository = voluntaryRepository;
    }


    @GetMapping
    public List<Voluntary> getRoot() {
        return voluntaryRepository.findAll();
    }
}
