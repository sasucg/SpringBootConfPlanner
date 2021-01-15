package com.project.demoproject.service;

import com.project.demoproject.entities.Admin;
import com.project.demoproject.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.getAllAdmins();
    }

    @Transactional
    public void addAdmin(List<Admin> admins) {
        admins.forEach(admin -> adminRepository.addAdmin(admin));
    }
}
