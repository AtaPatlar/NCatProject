package com.example.demo.entity;

import com.example.demo.entity.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Teacher{

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


    public Teacher(String name, String lastName, String email, String phoneNumber, String password, String tcNo, Role role) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.tcNo = tcNo;
        this.role = role;
    }

    public Teacher() {
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

    public static class TeacherBuilder {

        private String id;
        private String name;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String password;
        private String tcNo;
        private Role role;


        public Teacher build() {
            Teacher teacher = new Teacher();
            teacher.setId(id);
            teacher.setName(name);
            teacher.setLastName(lastName);
            teacher.setEmail(email);
            teacher.setPassword(password);
            teacher.setPhoneNumber(phoneNumber);
            teacher.setTcNo(tcNo);
            teacher.setRole(role);

            return teacher;
        }

        public TeacherBuilder id(String id) {
            this.id = id;
            return this;
        }

        public TeacherBuilder name(String id) {
            this.name = name;
            return this;
        }

        public TeacherBuilder lastName(String id) {
            this.lastName = lastName;
            return this;
        }

        public TeacherBuilder email(String email) {
            this.email = email;
            return this;
        }

        public TeacherBuilder password(String password) {
            this.password = password;
            return this;
        }

        public TeacherBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public TeacherBuilder tc(String tcNo) {
            this.tcNo = tcNo;
            return this;
        }
        public TeacherBuilder role(Role role){
            this.role=role;
            return this;
        }


    }
}

