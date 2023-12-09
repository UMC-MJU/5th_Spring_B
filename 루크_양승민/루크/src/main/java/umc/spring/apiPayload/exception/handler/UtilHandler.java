package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class UtilHandler extends GeneralException {
    public UtilHandler(BaseErrorCode code) {
        super(code);
    }
}
