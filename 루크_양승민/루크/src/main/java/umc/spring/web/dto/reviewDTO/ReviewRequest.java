package umc.spring.web.dto.reviewDTO;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class ReviewRequest {

    @Getter
    public static class AddDto {

        @NotEmpty
        String content;

        @Size(max = 5)
        Float score;

        @NotEmpty
        Long memberId;

        @NotEmpty
        Long storeId;

        List<MultipartFile> reviewImage;
    }
}
