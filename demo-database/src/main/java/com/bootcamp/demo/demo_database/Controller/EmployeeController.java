package com.bootcamp.demo.demo_database.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_database.entity.EmployeeEntity;
import com.bootcamp.demo.demo_database.repository.EmployeeRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EmployeeController {
  @Autowired
  private EmployeeRepository employeeRepository;

  // ! repository.save() -> insert into
  @PostMapping(value = "/employee")
  public EmployeeEntity create(@RequestBody EmployeeEntity employeeEntity) {
    return this.employeeRepository.save(employeeEntity);
  }

  // ! repository.findAll() -> select * from xxx
  @GetMapping(value = "/employees")
  public List<EmployeeEntity> getAll() {
    return this.employeeRepository.findAll();
  }

  // ! repository.findById() -> select * from xxx where id = ?
  @GetMapping(value = "/employee")
  public EmployeeEntity getById(@RequestParam Long id) {
    // return this.employeeRepository.findById(id).orElse(null);
    Optional<EmployeeEntity> employee = this.employeeRepository.findById(id);
    if (employee.isPresent()) {
      return employee.get();
    }
    return null;
  }

  @PutMapping(value = "/employee")
  public EmployeeEntity updateById(@RequestParam Long id,
      @RequestBody EmployeeEntity employeeEntity) {
    if (id == null || !id.equals(employeeEntity.getId())) {
      return null;
    }
    return this.employeeRepository.findById(id).map(e -> {
      e.setAge(employeeEntity.getAge());
      e.setJoinDate(employeeEntity.getJoinDate());
      e.setName(employeeEntity.getName());
      e.setSalary(employeeEntity.getSalary());
      EmployeeEntity saved = this.employeeRepository.save(e);
      return saved;
    }).orElse(null);
    // if (!this.employeeRepository.findById(id).isPresent()) {
    // return null;
    // }
    // return this.employeeRepository.save(employeeEntity);
  }

  @PatchMapping(value = "/employee/salary/{salary}")
  public EmployeeEntity patchSalary(@RequestParam Long id,
      @PathVariable Double salary) {
    if (id == null) {
      return null;
    }
    return this.employeeRepository.findById(id).map(e -> {
      e.setSalary(BigDecimal.valueOf(salary));
      EmployeeEntity saved = this.employeeRepository.save(e);
      return saved;
    }).orElse(null);
  }

  // ! repository.deleteById() -> delete from xxx where id =?
  @DeleteMapping(value = "/employee")
  public void deleteById(@RequestParam Long id) {
    if (id == null)
      return;
      this.employeeRepository.deleteById(id);
  }
}
