package com.project.demoproject.entities;

public class Admin {
    public Admin(int adminId, String adminName) {
        AdminId = adminId;
        AdminEmail = adminName;
    }

    public Admin() {
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int adminId) {
        AdminId = adminId;
    }

    public String getAdminEmail() {
        return AdminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        AdminEmail = adminEmail;
    }

    private int AdminId;
    private String AdminEmail;
}
