package com.example.demo.service.impl;

import com.example.demo.entity.Futsal;
import com.example.demo.pojo.FutsalPojo;
import com.example.demo.repo.FutsalRepository;
import com.example.demo.service.FutsalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class FutsalServiceImpl implements FutsalService {
    private final FutsalRepository futsalRepository;
    @Override
    public List<Futsal> findAll() {
        return futsalRepository.findAll();
    }
    @Override
    public void saveData(FutsalPojo futsalPojo) {
        Futsal futsal = new Futsal();
        futsal.setId(futsalPojo.getId());
        futsal.setGroundName(futsalPojo.getGroundname());

        futsalRepository.save(futsal);

    }
    @Override
    public void deleteById(int id) {
          futsalRepository.deleteById(id);
    }
}
