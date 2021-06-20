package com.example.Hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="schools")
public class School {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="school_name")	
	private String schoolName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="starting_date")
	Date startingDate;
	
	@Column(name="finishing_date")
	Date finishingDate;
	
	public String getFinishingDate() {
	if(this.finishingDate == null)
		return "Devam ediyor";
		return this.finishingDate.toString();
	}
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="user_id")
	private JobSeeker jobSeeker;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy ="schools")
	private List<Background> backgrounds;
	
}
