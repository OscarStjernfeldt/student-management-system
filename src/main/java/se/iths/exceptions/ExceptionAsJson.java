package se.iths.exceptions;

import java.time.LocalDateTime;

public class ExceptionAsJson {

    LocalDateTime localDateTime;

    String errorMessage;

    int errorCode;

    public ExceptionAsJson(String errorMessage, int errorCode) {
        this.localDateTime = LocalDateTime.now();
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
