package com.example.Hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class VerificationCode {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;
@Column(name="code")
private String code;
@Column(name="is_verified",columnDefinition="boolean default false")
private boolean isVeried;
@Column(name="verified_date")
private LocalDate verifiedDate=LocalDate.now();
}
