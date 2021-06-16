package com.example.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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
@PrimaryKeyJoinColumn(name="user_id")
@Entity
@Table(name="employers")
public class Employer extends User {
	@NotBlank(message="Bu Alan Doldurulmalıdır.")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message="Bu Alan Doldurulmalıdır.")
	@Column(name="web_site")
	private String webSite;
	
	
	@Size(min=12, max=12, message="Telefon numarası 12 haneli olmalıdır")
	@NotBlank(message="Bu Alan Doldurulmalıdır.")
	@Column(name="phone_number")
	private String phoneNumber;
	
	
	@OneToMany(mappedBy="employer")
	private List<JobAdvertisement>jobAdvertisement;
}
