package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.Store.StoreRequest;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Store addReview(Long storeId, Long memberId, StoreRequest.AddReviewDto request) {
        Member member = memberRepository.getReferenceById(memberId);
        Store store = storeRepository.getReferenceById(storeId);

        Review review = ReviewConverter.toReview(member, request);

        store.getReviewList().add(review);

        return store;
    }


    @Override
    @Transactional
    public Store addMission(Long storeId, StoreRequest.AddMissionDto request) {
        Store store = storeRepository.getReferenceById(storeId);

        Mission mission = MissionConverter.toMission(request);

        store.getMissionList().add(mission);

        return store;
    }
}
