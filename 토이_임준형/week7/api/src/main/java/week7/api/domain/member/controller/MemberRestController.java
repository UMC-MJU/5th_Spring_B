package week7.api.domain.member.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week7.api.global.code.ApiResponse;
import week7.api.domain.member.converter.MemberConverter;
import week7.api.domain.member.domain.Member;
import week7.api.domain.member.dto.MemberRequestDTO;
import week7.api.domain.member.dto.MemberResponseDTO.JoinResultDTO;
import week7.api.domain.member.service.MemberCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
