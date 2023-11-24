package week7.api.apiPayload.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week7.api.apiPayload.code.status.ErrorStatus;
import week7.api.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }

}
