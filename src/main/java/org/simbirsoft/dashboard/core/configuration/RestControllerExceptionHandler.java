package org.simbirsoft.dashboard.core.configuration;

import org.simbirsoft.dashboard.core.entity.ErrorInfo;
import org.simbirsoft.dashboard.core.entity.ValidationErrorInfo;
import org.simbirsoft.dashboard.core.exeprion.ErrorCodes;
import org.simbirsoft.dashboard.core.exeprion.RestApiException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo handleRestApiException(RestApiException exception) {
        return new ErrorInfo(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo handleValidationException(MethodArgumentNotValidException exception) {

        List<ValidationErrorInfo> validationErrorInfos = exception.getBindingResult().getAllErrors().stream()
                .map(error -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorCode = error.getCode();
                    Object rejectedValue = ((FieldError) error).getRejectedValue();
                    String errorMessage = error.getDefaultMessage();
                    return new ValidationErrorInfo(fieldName, errorCode, rejectedValue, errorMessage);
                }).collect(Collectors.toList());
        return new ErrorInfo(ErrorCodes.VALIDATION_FAILED_ERROR, validationErrorInfos);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInfo handleException(Exception exception) {
        return new ErrorInfo(ErrorCodes.GLOBAL_ERROR, exception.getMessage());
    }
}
