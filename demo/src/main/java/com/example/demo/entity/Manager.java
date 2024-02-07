package com.example.demo.entity;


import com.example.demo.entity.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private  String tcNo;
    private Role role;


    public Manager(String name, String lastName, String email, String phoneNumber, String password, String tcNo, Role role) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.tcNo = tcNo;
        this.role = role;
    }

    public Manager() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static class ManagerBuilder{

        private String id;
        private String name;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String password;
        private String tcNo;
        private Role role;


        public Manager build(){
            Manager manager=new Manager();
            manager.setId(id);
            manager.setName(name);
            manager.setLastName(lastName);
            manager.setEmail(email);
            manager.setPassword(password);
            manager.setPhoneNumber(phoneNumber);
            manager.setTcNo(tcNo);
            manager.setRole(role);

            return manager;
        }

        public ManagerBuilder id(String id){
            this.id=id;
            return this;
        }
        public ManagerBuilder name(String id){
            this.name=name;
            return this;
        }
        public ManagerBuilder lastName(String id){
            this.lastName=lastName;
            return this;
        }

        public ManagerBuilder email(String email){
            this.email=email;
            return this;
        }
        public ManagerBuilder password(String password){
            this.password=password;
            return this;
        }
        public ManagerBuilder phoneNumber(String phoneNumber){
            this.phoneNumber=phoneNumber;
            return this;
        }
        public ManagerBuilder tc(String tcNo){
            this.tcNo=tcNo;
            return this;
        }

        public ManagerBuilder role(Role role){
            this.role=role;
            return this;
        }




    }
}

