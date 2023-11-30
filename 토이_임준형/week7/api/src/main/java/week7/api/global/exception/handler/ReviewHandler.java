package week7.api.global.exception.handler;

import week7.api.global.code.BaseErrorCode;
import week7.api.global.exception.GeneralException;

public class ReviewHandler extends GeneralException {

    public ReviewHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
