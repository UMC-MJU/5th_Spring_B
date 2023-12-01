package week7.api.global.practicetemp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week7.api.global.code.status.ErrorStatus;
import week7.api.global.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }

}
