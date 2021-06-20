package cloudinary.concretes;

import java.io.IOException;
import java.util.Collections;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Hrms.core.utilities.results.DataResult;
import com.example.Hrms.core.utilities.results.SuccessDataResult;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import cloudinary.abstracts.ClaudinaryFileService;

@Service
public class ClaudinaryFileManager implements ClaudinaryFileService {
	

 private Cloudinary cloudinary;

 @Autowired
public ClaudinaryFileManager() {
	cloudinary =new Cloudinary(ObjectUtils.asMap("cloud_name", "hrms-kodlama-io",
			"api_key", "696778889461736",
			"api_secret", "EnKSkrDN2hpY2zSU4CZXhKybg3Q"));
	  
}
 

			@Override
			public DataResult<?> upload(MultipartFile multipartFile) throws IOException {
				var result = this.cloudinary.uploader().upload(multipartFile.getBytes(), Collections.emptyMap());
				return new SuccessDataResult<>(result.get("secure_url").toString());

			}

			

			@Override
			public DataResult<?> delete(int id) throws IOException {
				var result = this.cloudinary.uploader().upload(id, Collections.emptyMap());
		        return new SuccessDataResult<>(result);
			}
			
}
	
