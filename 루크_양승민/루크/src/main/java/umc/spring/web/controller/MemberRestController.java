package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.memberService.command.MemberCommandService;
import umc.spring.service.memberService.query.MemberQueryService;
import umc.spring.web.dto.memberDTO.MemberRequest;
import umc.spring.web.dto.memberDTO.MemberResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponse.JoinResultDTO> join(
            @RequestBody @Valid MemberRequest.JoinDto request
    ) {
        MemberResponse.JoinResultDTO resultDTO = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(resultDTO);
    }

    @GetMapping("/{memberId}/reviews")
    public ApiResponse<MemberResponse.ReviewPreviewListDTO> getReviewList(
            @PathVariable("memberId") Long memberId,
            @RequestParam("page") Integer page
    ) {
        MemberResponse.ReviewPreviewListDTO resultDTO = memberQueryService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(resultDTO);
    }

    @GetMapping("/{memberId}/missions")
    public ApiResponse<MemberResponse.MissionListDTO> getMissionList(
            @PathVariable("memberId") Long memberId,
            @RequestParam("page") Integer page
    ) {
        MemberResponse.MissionListDTO resultDTO = memberQueryService.getMisisonList(memberId, page);
        return ApiResponse.onSuccess(resultDTO);
    }

}
