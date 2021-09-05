package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "Ads")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ad {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty
  private long id;

  @Column
  @JsonProperty
  private String title;

  @Column
  @JsonProperty
  private String description;

  @Column
  @JsonProperty
  private String category;

  @Column
  @JsonProperty
  private LocalDate creationDate;

  @JsonProperty
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long user;
}
