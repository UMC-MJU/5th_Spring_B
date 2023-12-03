package umc.spring.web.dto.reviewDTO;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class ReviewRequest {

    @Getter
    public static class AddDto {

        @NotEmpty
        String title;
        @NotEmpty
        Float score;
        @NotEmpty
        Long memberId;
        @NotEmpty
        Long storeId;

        List<MultipartFile> reviewImage;
    }
}
