package com.MPFE.PracticaTendenciaSoftware.repository;

import com.MPFE.PracticaTendenciaSoftware.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface userRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT user from user u where u.username=:login and u.password=:password")
    public User loginUser(@Param("login") String login, @Param("password") String password);

}
