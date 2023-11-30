package week7.api.global.exception.handler;

import week7.api.global.code.BaseErrorCode;
import week7.api.global.exception.GeneralException;

public class StoreHandler extends GeneralException {

    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
