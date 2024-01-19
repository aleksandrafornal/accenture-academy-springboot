package com.accenture.academy.priest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class PriestGlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PriestNotFoundException.class)
    String priestNotFoundExceptionHandler(PriestNotFoundException exception){
        return exception.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidNameException.class)
    String invalidIdExceptionHandler(InvalidNameException exception){
        return exception.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    List<String> bindExceptionHandler(BindException exception){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<String> stringList = new ArrayList<>();
        for (FieldError fieldError : fieldErrors){
            stringList.add(fieldError.getDefaultMessage());
        }
        return stringList;
    }
}
