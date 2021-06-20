package com.example.Hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
private int id;
private String companyName;
private String jobPositionName;
private int openPositionAmount;
private Date createdAt;
private Date applicationDeadline;
}
