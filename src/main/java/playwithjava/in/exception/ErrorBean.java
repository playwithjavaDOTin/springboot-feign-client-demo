package playwithjava.in.exception;

import lombok.Data;

@Data
public class ErrorBean {
    private String code;
    private String message;
    private String errorCode;
    private String errorMessage;
}
