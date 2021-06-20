package com.example.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="programming_language")
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguage {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;

@Column(name="language")
private String language;

@JsonIgnore
@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="programmingLanguage")
private List<Background> backgrounds;

}
