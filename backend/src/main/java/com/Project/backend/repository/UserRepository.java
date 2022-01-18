package com.Project.backend.repository;

import com.Project.backend.model.user;
import com.Project.backend.queries.UserQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<user, String> {

    @Query(value = UserQueries.GetBudgetByTokenQuery, nativeQuery = true)
    Double getByToken(String usertoken);

    @Transactional @Modifying
    @Query(value = UserQueries.DecrementBudgetByTokenQuery, nativeQuery = true)
    void decrementBudget(String usertoken, Double epsilon);

}
