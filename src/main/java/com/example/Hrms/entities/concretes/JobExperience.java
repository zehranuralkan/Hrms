package com.example.Hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="job_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class JobExperience {
	
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;

		
		@Column(name="work_place_name")
		private String workPlaceName;
		
		@Column(name="position")
		private String position;
		
		@Column(name="starting_date")
		private Date startingDate;

		@Column(name="finishing_date")
		private Date finishingDate;
		
		@Column(name="created_at")
		LocalDate createdAt=LocalDate.now();
		
		@Column(name="is_activated")
		private boolean isActivated;
		
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="user_id")
		private JobSeeker jobSeeker;
		
		
		@JsonIgnore
		@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "jobExperience")
		private List<Background> backgrounds;
		
		
		public String getFinishDate() {
			if(this.finishingDate == null)
				return "Devam ediyor";
			return this.finishingDate.toString();
		}
	}

