package com.bootcamp.demo.demo_forum.codelib;

import com.bootcamp.demo.demo_forum.exception.ErrorMessage;

public class GResponse<T> {
  private Integer code;
  private String message;
  private T data;

  public Integer getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }

  public static <T> Builder<T> builder() {
    return new Builder<>();
  }

  public GResponse(Builder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static class Builder<T> {
    private Integer code;
    private String message;
    private T data;

    public Builder() {
      this.code = 0;
      this.message = "OK.";
    }

    public Builder<T> ok() {
      this.code = SysCode.OK.getCode();
      this.message = SysCode.OK.getMessage();
      return this;
    }

    public Builder<T> fail() {
      this.code = SysCode.FAIL.getCode();
      this.message = SysCode.FAIL.getMessage();
      return this;
    }

    public Builder<T> config(SysCode sysCode) {
      this.code = sysCode.getCode();
      this.message = sysCode.getMessage();
      return this;
    }

    // ! setter
    // public Builder<T> code(Integer code) {
    //   this.code = code;
    //   return this;
    // }

    // ! setter
    // public Builder<T> message(String message) {
    //   this.message = message;
    //   return this;
    // }

    public Builder<T> data(T data) {
      this.data = data;
      return this;
    }

    public GResponse<T> build() {
      return new GResponse<>(this);
    }
  }

  public static void main(String[] args) {
    GResponse<ErrorMessage> response = GResponse.<ErrorMessage>builder() //
        .fail()
        .data(new ErrorMessage(999, "ABCDE")).build();

    System.out.println(response.getCode());
    System.out.println(response.getMessage());
    System.out.println(response.getData());
  }
}