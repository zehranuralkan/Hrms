package com.example.Hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Hrms.business.abstracts.BackgroundService;
import com.example.Hrms.business.abstracts.ForeignLanguageService;
import com.example.Hrms.business.abstracts.JobExperienceService;
import com.example.Hrms.business.abstracts.JobSeekerService;
import com.example.Hrms.business.abstracts.ProgrammingLanguageService;
import com.example.Hrms.business.abstracts.SchoolService;
import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.ErrorDataResult;
import com.example.Hrms.core.utilities.results.ErrorResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.core.utilities.results.SuccessDataResult;
import com.example.Hrms.core.utilities.results.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.BackgroundDao;
import com.example.Hrms.entities.concretes.Background;
import com.example.Hrms.entities.concretes.JobExperience;
import com.example.Hrms.entities.dtos.BackgroundDto;

import cloudinary.abstracts.ClaudinaryFileService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Service
@NoArgsConstructor
@AllArgsConstructor
public class BackgroundManager implements BackgroundService {
	@Autowired

private BackgroundDao backgroundDao;
private ClaudinaryFileService claudinaryFileService;
private JobSeekerService jobSeekerService;
private JobExperienceService jobExperienceService;
private ForeignLanguageService foreignLanguageService;
private ProgrammingLanguageService programmingLanguageService;
private SchoolService schoolService;
	@Override
	public DataResult<List<Background>> getAll() {
		return new SuccessDataResult<List<Background>>(this.backgroundDao.findAll(),"Özgeçmişler listelendi");

	}

	@Override
	public DataResult<Background> getById(int backgroundId) {
		var result = this.backgroundDao.findById(backgroundId);
		return result.isEmpty() ? new ErrorDataResult<Background>("Özgeçmiş bulunamadı")
								: new SuccessDataResult<Background>(result.get());

	}

	@Override
	public DataResult<List<Background>> getByJobSeekerId(int user_id) {
		var result = this.backgroundDao.getByJobSeeker_Id(user_id);
		return result.isEmpty() ? new ErrorDataResult<List<Background>>(" özgeçmiş bulunamadı")
								: new SuccessDataResult<List<Background>>(result);
	
	}

	@Override
	public Result add(BackgroundDto backgroundAddDto) {
		var jobSeeker = this.jobSeekerService.getById(backgroundAddDto.getJobSeekerId());
		if(!jobSeeker.isSuccess())
			return jobSeeker;
		
		var background = new Background(
				jobSeeker.getData(),
				backgroundAddDto.getGithub(),
				backgroundAddDto.getLinkedin(),
				backgroundAddDto.getCoverLetter());
		
		for(int schoolId : backgroundAddDto.getSchoolIds()) {
			var school = this.schoolService.getById(schoolId).getData();
			background.getSchools().add(school);
		}
		
		for(int jobExperienceId : backgroundAddDto.getJobExperienceIds()) {
			var jobExperience = this.jobExperienceService.getById(jobExperienceId).getData();
			background.getJobExperience().add((JobExperience) jobExperience);
		}
		
		for(int foreignLanguageId : backgroundAddDto.getForeignLanguageIds()) {
			var foreignLanguage = this.foreignLanguageService.getById(foreignLanguageId).getData();
			background.getForeignLanguage().add(foreignLanguage);
		}
	
		for(int programmingLanguageId : backgroundAddDto.getProgrammingLanguageIds()) {
			var programmingLanguage = this.programmingLanguageService.getById(programmingLanguageId).getData();
			background.getProgrammingLanguage().add(programmingLanguage);
		}
		
		this.backgroundDao.save(background);
		return new SuccessResult("Özgeçmiş eklendi");
	}

	@Override
	public Result addImage(MultipartFile multipartFile, int backgroundId) throws IOException {
		var resumeIsExist = this.getById(backgroundId);
		if(!resumeIsExist.isSuccess()) {
			return resumeIsExist;
		}
		var imageAdd = this.claudinaryFileService.upload(multipartFile);
		if(!imageAdd.isSuccess()) {
			return new ErrorResult("Resim eklenemedi");
		}
		
		var currentResume = resumeIsExist.getData();
        Map<String, String> newImage = (Map<String, String>) imageAdd.getData();
        
        currentResume.setImageUrl((newImage.get("url"))); 

        return new SuccessResult("Özgeçmişe resim eklendi");

	}

}
