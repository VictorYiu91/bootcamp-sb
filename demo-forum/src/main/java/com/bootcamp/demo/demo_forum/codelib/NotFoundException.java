package com.bootcamp.demo.demo_forum.codelib;

public class NotFoundException extends BusinessException {
  public NotFoundException(SysCode sysCode) {
    super(sysCode);
  }
}