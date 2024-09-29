package com.voluntariadogeolocalizado.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "opportunities")
public class Opportunity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String description;
  private String location;
  private LocalDateTime eventDate;
  private String duration;
  private String requirements;
  private String category;
  @CreatedDate
  private LocalDateTime createdDate;

  @ManyToOne
  @JoinColumn(name = "ong_id")
  private Ong ong;

  @OneToMany(mappedBy = "opportunity", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
  private List<Registration> registrations;

  public Opportunity() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public LocalDateTime getEventDate() {
    return eventDate;
  }

  public void setEventDate(LocalDateTime eventDate) {
    this.eventDate = eventDate;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getRequirements() {
    return requirements;
  }

  public void setRequirements(String requirements) {
    this.requirements = requirements;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public Ong getOng() {
    return ong;
  }

  public void setOng(Ong ong) {
    this.ong = ong;
  }

  public List<Registration> getRegistrations() {
    return registrations;
  }

  public void setRegistrations(
      List<Registration> registrations) {
    this.registrations = registrations;
  }
}
