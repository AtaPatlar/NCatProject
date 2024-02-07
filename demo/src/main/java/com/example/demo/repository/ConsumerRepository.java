package com.example.demo.repository;


import com.example.demo.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer,String> {

    Optional<Consumer> findOptionalByEmail(String email);
    boolean existsByEmail(String email);

    @Query(value = "SELECT * FROM consumer u WHERE u.role = 2",nativeQuery = true)
    List<Consumer> findAllByStudent();

    @Query(value = "SELECT * FROM consumer u WHERE u.role = 1",nativeQuery = true)
    List<Consumer> findAllByTeacher();
}
