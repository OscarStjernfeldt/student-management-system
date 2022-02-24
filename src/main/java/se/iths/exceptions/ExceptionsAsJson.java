package se.iths.exceptions;

import java.time.LocalDateTime;

public class ExceptionsAsJson {

    private LocalDateTime localDateTime;
    private String errorMessage;
    private int errorCode;

    public ExceptionsAsJson(String errorMessage, int errorCode) {
        this.localDateTime = LocalDateTime.now();
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
