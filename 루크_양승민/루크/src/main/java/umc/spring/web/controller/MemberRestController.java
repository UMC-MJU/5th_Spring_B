package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.memberService.command.MemberCommandService;
import umc.spring.service.memberService.query.MemberQueryService;
import umc.spring.validation.page.annotation.CheckPage;
import umc.spring.web.dto.memberDTO.MemberRequest;
import umc.spring.web.dto.memberDTO.MemberResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @Operation(
            summary = "회원가입 API",
            description = "유저의 정보를 받아 회원가입을 합니다."
    )
    @PostMapping("/")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<MemberResponse.JoinResultDTO> join(
            @RequestBody @Valid MemberRequest.JoinDto request
    ) {
        MemberResponse.JoinResultDTO resultDTO = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(resultDTO);
    }

    @Operation(
            summary = "특정 사용자의 리뷰리스트 간단 조회 API",
            description = "특정 유저의 ID를 받아 리뷰리스트를 조회합니다. (Paging 있음: query String으로 page번호 입력)"
    )
    @GetMapping("/{memberId}/reviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    @Parameters({
            @Parameter(name = "memberId", description = "사용자 ID (Path Variable)"),
            @Parameter(name = "page", description = "페이지 번호 (Query String: 0번이 1페이지)")
    })
    public ApiResponse<MemberResponse.ReviewPreviewListDTO> getReviewList(
            @PathVariable("memberId") Long memberId,
            @CheckPage @RequestParam("page") Integer page
    ) {
        MemberResponse.ReviewPreviewListDTO resultDTO = memberQueryService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(resultDTO);
    }

    @Operation(
            summary = "특정 사용자의 미션리스트 조회 API",
            description = "특정 유저의 ID를 받아 미션리스트를 조회합니다. (Paging 있음: query String으로 page번호 입력)"
    )
    @GetMapping("/{memberId}/missions")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    @Parameters({
            @Parameter(name = "memberId", description = "사용자 ID (Path Variable)"),
            @Parameter(name = "page", description = "페이지 번호 (Query String: 0번이 1페이지)")
    })
    public ApiResponse<MemberResponse.MissionListDTO> getMissionList(
            @PathVariable("memberId") Long memberId,
            @CheckPage @RequestParam("page") Integer page
    ) {
        MemberResponse.MissionListDTO resultDTO = memberQueryService.getMisisonList(memberId, page);
        return ApiResponse.onSuccess(resultDTO);
    }

}
