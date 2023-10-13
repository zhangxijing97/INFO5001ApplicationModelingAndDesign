package model;

import java.util.ArrayList;

public class Faculty {
    String fullName;
    String position;
    String department;
    ArrayList<String> topics;
    String email;
    String phoneNumber;
    String fileName;

    public Faculty(String f, String p, String d, String e){
        fullName = f;
        position = p;
        department = d;
        email = e;
    }

    public Faculty(){
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public ArrayList<String> getTopics() {
        return topics;
    }
    public void setTopics(ArrayList<String> topics) {
        this.topics = topics;
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
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void printInformation(){
        System.out.println(fullName + " " + position + " " + department + " " + email);
    }

}
