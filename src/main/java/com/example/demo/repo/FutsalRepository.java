package com.example.demo.repo;

import com.example.demo.entity.Futsal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FutsalRepository extends JpaRepository<Futsal, Integer> {


}
