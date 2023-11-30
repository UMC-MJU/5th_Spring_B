package week7.api.domain.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week7.api.apiPayload.code.ApiResponse;
import week7.api.domain.dto.MemberRequestDTO;
import week7.api.domain.dto.MemberResponseDTO;
import week7.api.domain.dto.MemberResponseDTO.JoinResultDTO;
import week7.api.domain.service.MemberCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        return null;
    }
}
