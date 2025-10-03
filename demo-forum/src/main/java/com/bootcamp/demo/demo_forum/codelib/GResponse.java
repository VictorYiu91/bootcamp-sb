package com.bootcamp.demo.demo_forum.codelib;

import java.util.ArrayList;
import java.util.List;

public class GResponse<T> {
  private Integer code;
  private String message;
  private List<T> data;

  public Integer getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public List<T> getData() {
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
    private List<T> data;

    public Builder() {
      this.code = 0;
      this.message = "";
      this.data = new ArrayList<>();
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

    public Builder<T> data(List<T> data) {
      this.data = data;
      return this;
    }

    public GResponse<T> build() {
      return new GResponse<>(this);
    }
  }
}