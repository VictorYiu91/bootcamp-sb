package com.bootcamp.demo.demo_sb_helloworld;

public class Person {
  private String name;
  private Integer age;

  public Person(String name, Integer age) {
    this.name = name;
    this.age = age;
  }
  @Override
  public String toString() {
    return "Person("+ //
    "name = " + this.name +//
    ", age = " + this.age + //
    ")";
  }
}
