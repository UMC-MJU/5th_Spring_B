package week7.api.domain.review.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import week7.api.domain.review.dto.ReviewCreateRequest;
import week7.api.domain.review.dto.ReviewListResponse;
import week7.api.domain.review.dto.ReviewResponse;
import week7.api.domain.review.service.ReviewService;
import week7.api.global.code.ApiResponse;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // 리뷰 작성
    @PostMapping("/review")
    public ApiResponse<ReviewResponse> writeReview(@RequestBody @Valid ReviewCreateRequest request) {
        return ApiResponse.onSuccess(reviewService.registerReview(request));
    }

    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    @GetMapping("{storeId}/reviews")
    public ApiResponse<ReviewListResponse> getReviewList(@PathVariable Long storeId, Pageable pageable) {
        return ApiResponse.onSuccess(reviewService.getReviewList(storeId, pageable));
    }

    @Operation(summary = "내가 작성한 리뷰 목록 조회 API",
            description = "사용자가 작성한 리뷰들의 목록을 조회하는 API입니다. "
                    + "페이지네이션 기능이 포함되어 있으며, query string으로 page 번호와 size를 지정할 수 있습니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",
                    description = "OK, 성공적으로 리뷰 목록을 불러왔습니다.",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003",
                    description = "Access 토큰이 필요합니다.",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004",
                    description = "Access 토큰이 만료되었습니다.",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006",
                    description = "Access 토큰의 형식이 올바르지 않습니다.",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "page",
                    description = "페이지 번호 (0부터 시작)",
                    example = "0"),
            @Parameter(name = "size",
                    description = "한 페이지에 표시할 리뷰의 수",
                    example = "10")
    })
    @GetMapping("/myPage/reviews")
    public ApiResponse<ReviewListResponse> getMyReviewList(Pageable pageable) {
        return ApiResponse.onSuccess(reviewService.getMyReviewList(pageable));
    }
}
