package model;

import java.util.ArrayList;

public class FacultyDirectory {
    ArrayList<Faculty> facultylist;
    
    public FacultyDirectory() {
        facultylist = new ArrayList<Faculty>();
    }

    public Faculty addNewFaculty(String name, String postion, String department) {
        Faculty newFaculty = new Faculty(name, postion, department);
        facultylist.add(newFaculty);
        return newFaculty;
    }

    public void printFacultyList() {
        for (Faculty faculty: facultylist) {
            faculty.printinfo();
        }
    }

}
