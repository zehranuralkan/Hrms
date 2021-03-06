package com.example.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_seekers")
//@PrimaryKeyJoinColumn(name="user_id")
public class JobSeeker extends User {
	@NotBlank(message="Bu Alan Doldurulmalıdır.")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message="Bu Alan Doldurulmalıdır.")
	@Column(name="last_name")
	private String lastName;

	@NotBlank(message="Bu Alan Doldurulmalıdır.")
	@Column(name="identity_number")
	private String identityNumber;

	@Column(name="birth_year")
	private int birthYear;

	
	@JsonIgnoreProperties
	@OneToMany(mappedBy="jobSeeker")
	private List<School> schools;
	
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy="jobSeeker")
	private List<JobExperience> jobExperience;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<Background> backgrounds;

}
