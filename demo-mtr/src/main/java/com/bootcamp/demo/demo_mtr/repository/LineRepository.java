package com.bootcamp.demo.demo_mtr.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_mtr.entity.LineEntity;

@Repository
public interface LineRepository extends JpaRepository<LineEntity, Long>{
  // ! Native Query (3rd approach - product specific)
  // ! JPQL (2nd approach)

  // ! JPA method (1st approach)
  // Hibernate is able to auto generate the SQL for "findByCode"
  // -> select * from mte_lines where code = ?
  Optional<LineEntity> findByCode(String code);
}
