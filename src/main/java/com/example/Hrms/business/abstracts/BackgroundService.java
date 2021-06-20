package com.example.Hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.Result;
import com.example.Hrms.entities.concretes.Background;
import com.example.Hrms.entities.dtos.BackgroundDto;

public interface BackgroundService {
	DataResult<List<Background>> getAll();
	DataResult<Background> getById(int backgroundId);
	DataResult<List<Background>> getByJobSeekerId(int user_id);
	Result add(BackgroundDto backgroundAddDto);
	Result addImage(MultipartFile multipartFile, int backgroundId) throws IOException;
	}
