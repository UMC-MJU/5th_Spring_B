package week7.api.global.exception.handler;

import week7.api.global.code.BaseErrorCode;
import week7.api.global.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
