package com.project.demoproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demoproject.entities.Admin;
import com.project.demoproject.service.AdminService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmins() {

        List<Admin> admins = adminService.getAllAdmins();

        if (admins.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of());
        else return ResponseEntity
                .ok()
                .body(admins);
    }

    @PostMapping("/add")
    public void addAdmin(@RequestBody List<Admin> admins)    {
        adminService.addAdmin(admins);
    }
}
