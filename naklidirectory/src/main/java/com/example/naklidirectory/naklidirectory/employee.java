package com.example.naklidirectory.naklidirectory;

public class employee {
    private int empID;
    private String name;
    private String email;
    private int phone;
    employee(){}

    public employee(int empID, String name, String email, int phone) {
        this.empID = empID;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "employee{" +
                "empID=" + empID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
