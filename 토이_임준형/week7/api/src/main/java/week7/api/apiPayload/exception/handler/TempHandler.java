package week7.api.apiPayload.exception.handler;

import week7.api.apiPayload.code.BaseErrorCode;
import week7.api.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
