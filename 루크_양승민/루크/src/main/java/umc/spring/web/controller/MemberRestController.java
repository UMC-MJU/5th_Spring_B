package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.memberService.command.MemberCommandService;
import umc.spring.web.dto.memberDTO.MemberRequest;
import umc.spring.web.dto.memberDTO.MemberResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponse.JoinResultDTO> join(
            @RequestBody @Valid MemberRequest.JoinDto request
    ) {
        MemberResponse.JoinResultDTO resultDTO = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(resultDTO);
    }

}
