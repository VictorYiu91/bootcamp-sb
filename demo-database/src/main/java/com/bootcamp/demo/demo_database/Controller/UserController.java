package com.bootcamp.demo.demo_database.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_database.entity.UserEntity;
import com.bootcamp.demo.demo_database.mapper.UserMapper;
import com.bootcamp.demo.demo_database.model.User;
import com.bootcamp.demo.demo_database.repository.UserRepository;

@RestController
public class UserController {
  private static final String userURL =
      "https://jsonplaceholder.typicode.com/users";

  @Autowired
  private UserRepository userRepository;

  @GetMapping(value = "/users")
  public List<User> getUsers() {
    // ! getForObject() -> auto-deserialization
    User[] users = new RestTemplate().getForObject(userURL, User[].class);
    // Array -> ArrayList
    return Arrays.asList(users);
  }

  @PostMapping(value = "/users")
  public List<UserEntity> createUsers() {
    this.userRepository.deleteAll();

    List<User> users =
        Arrays.asList(new RestTemplate().getForObject(userURL, User[].class));
    // Convert List<User> to List<UserEntity>
    List<UserEntity> userEntities = users.stream() //
        .map(u -> new UserMapper().map(u)) //
        .collect(Collectors.toList());
    // saveAll
    return this.userRepository.saveAll(userEntities);
  }

}