package com.bootcamp.demo.demo_forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_forum.entity.CommentEntity;
import com.bootcamp.demo.demo_forum.entity.PostEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
  // ! @Query -> nativeQuery = true, hardcoded SQL (MySQL)

  // ! @Query -> nativeQuery = false, Hibernate generates SQL compatabile to target DB product
  // JPQL
  @Query(value = "select c from CommentEntity c where c.postEntity = :postEntity")
  List<CommentEntity> findByPost(@Param(value = "postEntity") PostEntity postEntity);
}