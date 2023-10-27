/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import Persona.Faculty.FacultyProfile;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {

    CourseCatalog coursecatalog;

    ArrayList<CourseOffer> schedule;
    String semester;

    public CourseSchedule(String s, CourseCatalog cc) {
        semester = s;
        coursecatalog = cc;
        schedule = new ArrayList();

    }

    public CourseOffer newCourseOffer(String  n) {

        Course c = coursecatalog.getCourseByNumber(n);
        if(c==null) return null;
        CourseOffer co;
        co = new CourseOffer(c);
        schedule.add(co);
        return co;
    }

    public CourseOffer getCourseOfferByNumber(String n) {

        for (CourseOffer co : schedule) {

            if (co.getCourseNumber().equals(n)) {
                return co;
            }
        }
        return null;
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule) {

            sum = sum + co.getTotalCourseRevenues();

        }
        return sum;
    }
    
    public void printCourseSchedule() {
        System.out.println("Course Schedule for " + semester);

        for (CourseOffer courseOffer : schedule) {
            System.out.println("**************************************************");
            System.out.println("Course Number: " + courseOffer.getCourseNumber());
    
            // Get and print course information
            Course course = courseOffer.getSubjectCourse();
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Credits: " + course.getCredits());
            System.out.println("Course Price: " + course.getCoursePrice());
    
            // Get and print teacher information
            System.out.println("Teacher: " + courseOffer.getFacultyName());

            // Count registered students and remaining empty seats
            int registeredStudents = courseOffer.getSeatAssignments();
            int emptySeats = courseOffer.getEmptySeats();
    
            System.out.println("Registered Students: " + registeredStudents);
            System.out.println("Remaining Empty Seats: " + emptySeats);
            System.out.println();

            System.out.println("");
        }
    }

    public void calculateAndPrintDepartmentRevenueBreakdown() {
        int departmentRevenue = 0;
    
        System.out.println("Department Revenue Breakdown for " + semester + ":\n");
    
        for (CourseOffer courseOffer : schedule) {
            int courseOfferRevenue = courseOffer.getTotalCourseRevenues();
            departmentRevenue += courseOfferRevenue;
    
            // Print the breakdown for each course offering
            System.out.println("Course Number: " + courseOffer.getCourseNumber());
            System.out.println("Course Name: " + courseOffer.getSubjectCourse().getCourseName());
            System.out.println("Course Offering Revenue: $" + courseOfferRevenue);
            System.out.println("------------------------------");
        }
    
        System.out.println("Total Department Revenue for " + semester + ": $" + departmentRevenue);
    }
    


}
