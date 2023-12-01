package week7.api.global.exception.handler;

import week7.api.global.code.BaseErrorCode;
import week7.api.global.exception.GeneralException;

public class FoodHandler extends GeneralException {

    public FoodHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
