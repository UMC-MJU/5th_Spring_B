package week7.api.apiPayload.exception.handler;

import week7.api.apiPayload.code.BaseErrorCode;
import week7.api.apiPayload.exception.GeneralException;

public class FoodHandler extends GeneralException {

    public FoodHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
