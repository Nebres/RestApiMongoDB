package com.spring.one.Springdemoproject.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Names {

    @Id
    private String id;
    private String name;
    private boolean status;
    private int idNumber;

    public Names(){}

    public Names(String name, boolean status, int idNumber) {
        this.name = name;
        this.status = status;
        this.idNumber = idNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public Names updateName(Names name) {
        this.name =  name.getName();
        this.status = name.isStatus();
        this.idNumber = name.getIdNumber();
        return this;
    }

    @Override
    public String toString() {
        return "Names{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", idNumber=" + idNumber +
                '}';
    }

}
