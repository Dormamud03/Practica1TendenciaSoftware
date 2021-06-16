package com.MPFE.PracticaTendenciaSoftware.repository;

import com.MPFE.PracticaTendenciaSoftware.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT o from user o where o.username= :login and o.password= :password")
    public User loginUser(@Param("login") String login, @Param("password") String password);

}
