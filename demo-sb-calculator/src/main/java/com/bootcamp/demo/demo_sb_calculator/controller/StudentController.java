package com.bootcamp.demo.demo_sb_calculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_calculator.model.Database;
import com.bootcamp.demo.demo_sb_calculator.model.Student;

@RestController
public class StudentController {
  @PostMapping("/student")
  public Student createStudent(@RequestBody Student student) {
    if (Database.studentDatabase.add(student)) {
      return student;
    }
    return null;
  }

  @GetMapping("/students")
  public List<Student> getAllStudents() {
    return Database.studentDatabase;
  }

  // ! Put -> assume 100% trust API User
  @PutMapping("/student")
  public Student updateStudent(@RequestParam Long id, @RequestBody Student student) {
    for (int i = 0; i < Database.studentDatabase.size(); i++) {
      if (id.equals(Database.studentDatabase.get(i).getId())) {
        return Database.studentDatabase.set(i, student);
      }
    }
    return null;
  }
  // ! Patch -> 

  // URL with parameters -> Two Desgins
  // 1. @PathVariable: http://localhost:8092/student/id/1/name/John
  // @PatchExchange("/student/id/{id}/name/{name}")
  // 2. @RequestParam: http://localhost:8092/student?id=1&name=John
  // @PatchMapping("/student") 

  @PatchMapping("/student")
  public Student patchStudent(@RequestParam Long id, @RequestParam String name) {
    for (int i = 0; i < Database.studentDatabase.size(); i++) {
      if (id.equals(Database.studentDatabase.get(i).getId())) {
        Student student = Database.studentDatabase.get(i);
        student.setName(name);
        return Database.studentDatabase.set(i, student);
      }
    }
    return null;
  }
}
