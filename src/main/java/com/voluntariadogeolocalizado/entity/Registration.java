package com.voluntariadogeolocalizado.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "registrations")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // private Voluntary voluntary;

    // private Opportunity opportunity;

    private LocalDateTime createdDate;

    public Registration() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Voluntary getVoluntary() {
//        return voluntary;
//    }
//
//    public void setVoluntary(Voluntary voluntary) {
//        this.voluntary = voluntary;
//    }

//    public Opportunity getOpportunity() {
//        return opportunity;
//    }
//
//    public void setOpportunity(Opportunity opportunity) {
//        this.opportunity = opportunity;
//    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
