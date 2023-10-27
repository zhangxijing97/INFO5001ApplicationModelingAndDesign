/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import CourseCatalog.Course;
import Persona.Faculty.FacultyAssignment;
import Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseOffer {

    Course course;
    ArrayList<Seat> seatlist;
    FacultyAssignment facultyassignment;

    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList();
    }
     
    public void AssignAsTeacher(FacultyProfile fp) {

        facultyassignment = new FacultyAssignment(fp, this);
    }

    public String getFacultyName() {
        if (facultyassignment != null) {
            FacultyProfile faculty = facultyassignment.getFacultyProfile();
            if (faculty != null) {
                return faculty.getFacultyName();
            }
        }
        return "Not Assigned";
    }    

    public FacultyProfile getFacultyProfile() {
        return facultyassignment.getFacultyProfile();
    }

    public String getCourseNumber() {
        return course.getCOurseNumber();
    }

    public void generateSeats(int n) {
        for (int i = 0; i < n; i++) {
            seatlist.add(new Seat(this, i));
        }

    }

    public Seat getEmptySeat() {
        for (Seat s : seatlist) {
            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }


    public SeatAssignment assignEmptySeat(CourseLoad cl) {
        Seat anEmptySeat = getEmptySeat();
        if (anEmptySeat == null) {
            return null;
        }
        SeatAssignment sa = anEmptySeat.newSeatAssignment(cl); //seat is already linked to course offer
        cl.registerStudent(sa); //coures offer seat is now linked to student
        return sa;
    }

    public int getTotalCourseRevenues() {

        int sum = 0;

        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }

        }
        return sum;
    }
    public Course getSubjectCourse(){
        return course;
    }
    public int getCreditHours(){
        return course.getCredits();
    }

    public int getEmptySeats() {
        int emptySeatsCount = 0;
        for (Seat seat : seatlist) {
            if (!seat.isOccupied()) {
                emptySeatsCount++;
            }
        }
        return emptySeatsCount;
    }

    public int getSeatAssignments() {
        int occupiedSeats = 0;
        for (Seat seat : seatlist) {
            if (seat.isOccupied()) {
                occupiedSeats++;
            }
        }
        return occupiedSeats;
    }

}
