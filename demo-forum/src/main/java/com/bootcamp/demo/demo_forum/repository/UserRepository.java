package com.bootcamp.demo.demo_forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_forum.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  // Native Query (Demo Wrong Column name -> SQL Exception)
  @Query(value = "select u.* from users u where u.names = :name", nativeQuery = true)
  List<UserEntity> findUsersByName(@Param(value = "name") String name);

}