package com.bootcamp.demo.demo_forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_forum.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
  
}
