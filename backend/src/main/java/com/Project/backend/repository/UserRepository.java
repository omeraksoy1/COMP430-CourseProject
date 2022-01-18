package com.Project.backend.repository;

import com.Project.backend.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<user, String> {

    @Query(value = "SELECT budget FROM userdetails WHERE token=:usertoken", nativeQuery = true)
    Double getByToken(String usertoken);

    @Transactional
    @Modifying
    @Query(value = "UPDATE userdetails SET budget=budget-:epsilon WHERE token = :usertoken", nativeQuery = true)
    void decrementBudget(String usertoken, Double epsilon);

}
