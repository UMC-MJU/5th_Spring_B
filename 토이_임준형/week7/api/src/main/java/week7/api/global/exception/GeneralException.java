package week7.api.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import week7.api.global.code.BaseErrorCode;
import week7.api.global.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return code.getReasonHttpStatus();
    }

}
