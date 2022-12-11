package com.nest.complaintappbackend.dao;

import com.nest.complaintappbackend.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `user` WHERE `username`= :username AND `password`= :password",nativeQuery = true)
    List<UserModel> FindUser(@Param("username") String username, @Param("password") String password);

}
