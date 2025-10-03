package com.bootcamp.demo.demo_forum.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
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
        .fail()//
        .build();
  }

  @ExceptionHandler(value = NotFoundException.class)
  public GResponse<String> handleNotFoundException(NotFoundException e) {
    return GResponse.<String>builder() //
        .config(SysCode.codeOf(e.getCode())) //
        .build();
  }
}