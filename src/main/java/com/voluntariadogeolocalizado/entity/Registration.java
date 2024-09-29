package com.voluntariadogeolocalizado.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "registrations")
public class Registration {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "voluntary_id")
  private Voluntary voluntary;

  @ManyToOne
  @JoinColumn(name = "opportunity_id")
  private Opportunity opportunity;

  @CreatedDate
  private LocalDateTime createdDate;

  private String status;

  public Registration() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Voluntary getVoluntary() {
    return voluntary;
  }

  public void setVoluntary(Voluntary voluntary) {
    this.voluntary = voluntary;
  }

  public Opportunity getOpportunity() {
    return opportunity;
  }

  public void setOpportunity(Opportunity opportunity) {
    this.opportunity = opportunity;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
