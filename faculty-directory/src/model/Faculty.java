package model;

import java.util.ArrayList;

public class Faculty {
    String name;
    String postion;
    String department;
    ArrayList<String>topics;
    String phoneNumber;

    public Faculty(String n, String p, String d) {
        name = n;
        postion = p;
        department = d;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPostion(String postion) {
        this.postion = postion;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setTopics(ArrayList<String> topics) {
        this.topics = topics;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
    public String getPostion() {
        return postion;
    }
    public String getDepartment() {
        return department;
    }
    public ArrayList<String> getTopics() {
        return topics;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void printinfo() {
        System.out.println(name+postion+department);
    }
}
