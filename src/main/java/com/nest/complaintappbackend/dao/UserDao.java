package com.nest.complaintappbackend.dao;

import com.nest.complaintappbackend.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `user` WHERE `username`= :username AND `password`= :password",nativeQuery = true)
    List<UserModel> UserLogin(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `user` WHERE `id`= :id",nativeQuery = true)
    List<UserModel> FindUserById(@Param("id") Integer id);

}
