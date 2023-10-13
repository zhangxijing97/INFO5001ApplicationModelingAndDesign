package model;

import java.util.ArrayList;

public class FacultyDirectory {
    ArrayList<Faculty> facultyList;
    
    public FacultyDirectory() {
        facultyList = new ArrayList<Faculty>();
    }

    public Faculty addNewFaculty(String fullName, String position, String department, String email){
        Faculty newFaculty = new Faculty(fullName, position, department, email);
        facultyList.add(newFaculty);
        return newFaculty;
    }

    public void removeFaculty(int index){
        facultyList.remove(index);
    }

    public void clearAllElements(){
        facultyList.clear();
    }

    public void printFacultyList(){
        System.out.println("Printing faculty list:");

        for (Faculty faculty : facultyList) {
            System.out.print(facultyList.indexOf(faculty) + 1 + ". ");
            faculty.printInformation();
        }

        printNumberOfElements();
    }

    public Faculty searchFaculty(String fullName){
        for (Faculty faculty : facultyList) {
            if (faculty.getFullName().equals(fullName)) {
                return faculty;
            }
        }
        return null;
    }

    public void printNumberOfElements(){
        System.out.println("Number of elements in the list: " + facultyList.size());
    }

    // TODO: We will add some additional methods here later.

}
