package com.bootcamp.demo.demo_forum.codelib;

public enum SysCode {
  OK(0, "OK."), //
  FAIL(99999, "Fail."), //
  ID_NOT_FOUND(99998, "ID Not Found."), //
  ENUM_NOT_FOUND(99997, "enum not found by code."), //
  SERVICE_NOT_FOUND(99996, "Service Endpoint Not Found."), //
  SQL_INVALID(99995, "SQL Invalid."), //
  ;

  private Integer code;
  private String message;

  private SysCode(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  // find enum by code
  public static SysCode codeOf(Integer code) {
    if (code == null)
      throw new NotFoundException(SysCode.ENUM_NOT_FOUND);
    for (SysCode s : values()) {
      if (s.getCode().equals(code))
        return s;
    }
    throw new NotFoundException(SysCode.ENUM_NOT_FOUND);
  }
}