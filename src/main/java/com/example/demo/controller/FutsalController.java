package com.example.demo.controller;


import com.example.demo.entity.Futsal;
import com.example.demo.pojo.FutsalPojo;
import com.example.demo.pojo.GlobalApilResponse;
import com.example.demo.service.FutsalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("futsal")
@RequiredArgsConstructor
public class FutsalController {

    private final FutsalService futsalService;

    @GetMapping("/list")
    public GlobalApilResponse<List<Futsal>> findAll(){
        GlobalApilResponse<List<Futsal>> globalApiResponse = new GlobalApilResponse<List<Futsal>>();
        globalApiResponse.setStatus(200);
        globalApiResponse.setData(futsalService.findAll());
        globalApiResponse.setMessage("data retrieved successfully");
        return globalApiResponse;


    }


    @PostMapping("/save")
    public GlobalApilResponse<String> futsal(@RequestBody FutsalPojo futsalPojo) {
        GlobalApilResponse<String> globalApiResponse = new GlobalApilResponse<String>();
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("data saved successfully");
        globalApiResponse.setData("saved");
        futsalService.saveData(futsalPojo);
        return globalApiResponse;
    }


    @PutMapping("/update")
    public void futsalUpdate(@RequestBody FutsalPojo futsalPojo) {
        futsalService.saveData(futsalPojo);
    }


    @DeleteMapping("/delete/{id}")
    public GlobalApilResponse<Integer> delete(@PathVariable Integer id){
        GlobalApilResponse<Integer> globalApiResponse= new GlobalApilResponse<>();
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("data deleted successfully");
        globalApiResponse.setData(id);
        this.futsalService.deleteById(id);
        return globalApiResponse;
    }

    @GetMapping("/getById/{id}")
    public Optional<Futsal> findById(@PathVariable Integer id){
        return this.futsalService.findById(id);
    }

}