package umc.spring.web.dto.reviewDTO;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;
import umc.spring.validation.exist.annotation.ExistMember;
import umc.spring.validation.exist.annotation.ExistStore;

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

        @ExistMember
        Long memberId;

        @ExistStore
        Long storeId;

        //TODO: reviewImage Validation 필요
        List<MultipartFile> reviewImage;
    }
}
