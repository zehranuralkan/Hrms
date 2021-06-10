package com.example.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site")
	private String webSite;

	@Column(name="phone_number")
	private String phoneNumber;

}
