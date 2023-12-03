package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class S3UploadService {

    public String saveFile(MultipartFile multipartFile) {
        return null;    //TODO: S3 적용시 구현 필요
    }
}
