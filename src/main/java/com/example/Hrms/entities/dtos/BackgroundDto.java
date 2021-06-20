package com.example.Hrms.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BackgroundDto {

	private int jobSeekerId;
	private String imageUrl;
	private String github;
	private String linkedin;
	private String coverLetter;
	
	List<Integer> schoolIds;
	List<Integer> jobExperienceIds;
	List<Integer> foreignLanguageIds;
	List<Integer> programmingLanguageIds;	
}
