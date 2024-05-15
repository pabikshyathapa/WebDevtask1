package com.example.demo.controller;

import com.example.demo.Entity.Role;
import com.example.demo.pojo.BookProjection;
import com.example.demo.pojo.GlobalApilResponse;
import com.example.demo.pojo.RolePojo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleController RoleService;

    @GetMapping("/list")
    public List<BookProjection> findAll() {
        return this.RoleService.findAll();
    }
    @GetMapping("/list2")
    public List<Role> findAll2() {
        return this.RoleService.findAll2();
    }
    @PostMapping("/save")
    public GlobalApilResponse<Integer> saveRole(@RequestBody RolePojo rolepojo) {
        GlobalApilResponse<Integer> globalApiResponse= new GlobalApilResponse<>();
        GlobalApilResponse<Integer> roleId= RoleService.saveRole(rolepojo);
        globalApiResponse.setData(roleId.getData());
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("data saved successfully");

        return globalApiResponse;
    }
    @PutMapping("/update")
    public void roleUpdate(@RequestBody RolePojo rolepojo) {
        RoleService.saveRole(rolepojo);
    }
    @DeleteMapping("/delete/{id}")
    public GlobalApilResponse<Integer> delete(@PathVariable Integer id) {
        GlobalApilResponse<Integer>globalApiResponse= new GlobalApilResponse<>();
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("data deleted successfully");
        globalApiResponse.setData(id);
        this.RoleService.deleteById(id);
        return globalApiResponse;
    }

    private void deleteById(Integer id) {
    }

    @GetMapping("/getById/{id}")
    public Role findById(@PathVariable Integer id) {
        return this.RoleService.findById(id);
    }

}