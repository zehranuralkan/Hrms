package com.example.Hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","verificationJobPostings"})
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_advertisement_id")
	private int jobAdvertisementId;
	
	@NotBlank(message="Bu Alan Doldurulmalıdır.")
	@Column(name="description")
	private String description;

	@Column(name="min_salary")
	private int minSalary;

	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="number_of_available_position")
	private int numberOfAvailablePos;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="is_active")
	private boolean isActive=false;
	
	@ManyToOne()
	@JoinColumn(name="jobtitles_id")
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JoinColumn(name="employers_user_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="city_city_id")
	private City city;
}
