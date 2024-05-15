package com.example.demo.repo;

import com.example.demo.pojo.BookProjection;
import com.example.demo.pojo.RoleProjection;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository {
    @Query(nativeQuery = true, value = "select id,role_id as roleId,ground_id as groundId")
    List<RoleProjection> findAllData();
}
