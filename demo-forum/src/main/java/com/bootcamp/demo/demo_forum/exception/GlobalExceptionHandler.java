package com.bootcamp.demo.demo_forum.exception;

import java.util.ArrayList;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.bootcamp.demo.demo_forum.codelib.GResponse;
import com.bootcamp.demo.demo_forum.codelib.NotFoundException;
import com.bootcamp.demo.demo_forum.codelib.SysCode;

// 全局攔截
@RestControllerAdvice
public class GlobalExceptionHandler {
  // ! 專業攔截 NumberFormatException
  // @ExceptionHandler(value = NumberFormatException.class)
  // public String handleNumberFormatException(NumberFormatException e) {
  // return "I got issue, please help. Reason=" + e.getMessage();
  // }
  @ExceptionHandler(value = NumberFormatException.class)
  public GResponse<ErrorMessage> handleNumberFormatException(
      NumberFormatException e) {
    ErrorMessage errorMessage = ErrorMessage.builder() //
        .code(999) //
        .message("I got issue, please help. " + e.getMessage()) //
        .build();
    return GResponse.<ErrorMessage>builder() //
        // .code(999)
        // .message("System Error.")
        .fail().data(errorMessage) //
        .build();
  }

  @ExceptionHandler(value = NotFoundException.class)
  public GResponse<String> handleNotFoundException(NotFoundException e) {
    return GResponse.<String>builder() //
        .config(SysCode.codeOf(e.getCode())) //
        .data(e.getMessage()) //
        .build();
  }

  @ExceptionHandler(value = RestClientException.class)
  public GResponse<Object> handleServiceNotFoundException(RestClientException e) {
    return GResponse.<Object>builder() //
      .config(SysCode.SERVICE_NOT_FOUND) //
      .data(new ArrayList<>()) //
      .build();
  }

  @ExceptionHandler(value = InvalidDataAccessResourceUsageException.class)
  public GResponse<Object> handleInvalidSqlException(InvalidDataAccessResourceUsageException e){
    return GResponse.<Object>builder() //
      .config(SysCode.SQL_INVALID) // invalid SQL
      .data(new ArrayList<>()) //
      .build();
  }

}