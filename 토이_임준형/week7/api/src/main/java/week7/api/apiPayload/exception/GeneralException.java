package week7.api.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import week7.api.apiPayload.code.BaseErrorCode;
import week7.api.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return code.getReasonHttpStatus();
    }

}
