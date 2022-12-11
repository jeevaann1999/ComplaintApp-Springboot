package com.nest.complaintappbackend.dao;

import com.nest.complaintappbackend.model.Complaints;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ComplaintsDao extends CrudRepository<Complaints,Integer> {

    @Query(value = "SELECT u.`address`, u.`email`, u.`name`, u.`phone`, u.`username`, c.complaints FROM `user` u JOIN complaints c ON c.userid=u.id", nativeQuery = true)
    List<Map<String, String>> GetComplaints();

    @Query(value = "SELECT `id`, `complaints`, `userid` FROM `complaints` WHERE `userid`= :userid",nativeQuery = true)
    List<Complaints> ViewMyComplaint(@Param("userid") Integer userid);
}
