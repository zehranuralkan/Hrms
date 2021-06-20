package cloudinary.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.Hrms.core.utilities.results.DataResult;

public interface ClaudinaryFileService {
	
DataResult<?> upload(MultipartFile multipartFile) throws IOException;
DataResult<?>delete(int id) throws IOException;
}
