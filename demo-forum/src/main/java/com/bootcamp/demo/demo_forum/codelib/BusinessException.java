package com.bootcamp.demo.demo_forum.codelib;

public class BusinessException extends RuntimeException {
  private Integer code;

  public BusinessException(SysCode sysCode) {
    super(sysCode.getMessage());
    this.code = sysCode.getCode();
  }

  public Integer getCode() {
    return this.code;
  }
}
