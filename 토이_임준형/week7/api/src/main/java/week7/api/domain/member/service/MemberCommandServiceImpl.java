package week7.api.domain.member.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week7.api.apiPayload.code.status.ErrorStatus;
import week7.api.apiPayload.exception.handler.FoodHandler;
import week7.api.domain.food.domain.Food;
import week7.api.domain.food.repository.FoodRepository;
import week7.api.domain.member.converter.MemberConverter;
import week7.api.domain.member.domain.Member;
import week7.api.domain.member.dto.MemberRequestDTO;
import week7.api.domain.member.repsitory.MemberRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        // Converter 활용 Member 객체 생성
        Member member = MemberConverter.toMember(request);

        // request 사용하여 food 검증 및 추출
        List<Food> foodList = request.getFoodCategory().stream()
                .map(category -> foodRepository.findById(category)
                        .orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .collect(Collectors.toList());

        // 갖고온 food, Member 연관관계 편의 메서드를 활용하여 양쪽에 값 세팅
        foodList.forEach(food -> food.mappingMember(member));

        // food 는 변경감지로 자동으로 값 할당
        return memberRepository.save(member);
    }


}
