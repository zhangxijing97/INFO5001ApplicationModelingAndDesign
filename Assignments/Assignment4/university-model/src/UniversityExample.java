//*********************************************************** 
// Name: Xijing Zhang
// Title: UniversityExample.java
// Description: Assignment4
// Date: Oct/26/2023
//***********************************************************

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import College.College;
import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import CourseSchedule.SeatAssignment;
import Department.Department;
import Persona.Person;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import Persona.Transcript;
import Persona.Faculty.FacultyDirectory;
import Persona.Faculty.FacultyProfile;

/**
 *
 * @author kal bugrara
 */
public class UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        // TODO code application logic here

        Department department = new Department("Information Systems");
      
        
        StudentDirectory sd = department.getStudentDirectory();
        PersonDirectory pd = department.getPersonDirectory();

        // Student side process
        Person archilPerson = pd.newPerson("0123", "Archil");
        StudentProfile archil = sd.newStudentProfile(archilPerson);
        
        Transcript archilsTranscript = archil.getTranscript();

        CourseLoad archilsSpring2024 = archilsTranscript.newCourseLoad("Spring2024");
        CourseLoad archilsCurrentCourseLoad = archil.getCurrentCourseLoad();


        // Course side
        
        CourseCatalog courseCatalog = department.getCourseCatalog();
        Course info5001 = courseCatalog.newCourse("info5001", "Application Design & Modeling", 4);    
        Course info5100 = courseCatalog.newCourse("info5100", "Application Engineering Development", 4);

        CourseSchedule csSpring2024 = department.newCourseSchedule("Spring2024");
        
        CourseOffer info5001offerSpring2024 = csSpring2024.newCourseOffer("info5001");
        CourseOffer info5100offerSpring2024 = csSpring2024.newCourseOffer("info5100");
        
        info5001offerSpring2024.generateSeats(10); // This means 10 students can take this class
        info5100offerSpring2024.generateSeats(5);
        
        SeatAssignment archilRegisteredForInfo5001inSpring2024 = info5001offerSpring2024.assignEmptySeat(archilsCurrentCourseLoad);
        SeatAssignment archilRegisteredForInfo5100 = info5100offerSpring2024.assignEmptySeat(archilsCurrentCourseLoad);
        

        archil.printTranscript();
        */

        // /*
        // Part 1 – Populating the model (20 points)
        // • 1(one) college
        // • 1(one) Department.
        // • 5(five) courses per program.
        // • 1(one) faculty for each course.
        // • 10(ten) students in each program.

        // Create a College object
        College college = new College("Northeastern University");

        // Create a Department object and associate it with the College
        Department department = new Department("Information Systems");
        // college.departments.add(department);

         // Create 5 courses object
        CourseCatalog courseCatalog = department.getCourseCatalog();
        Course info5001 = courseCatalog.newCourse("info5001", "Application Modeling & Design", 4);
        Course info5002 = courseCatalog.newCourse("info5002", "Introduction to Python for Information Systems", 4);
        Course info5100 = courseCatalog.newCourse("info5100", "Application Engineering and Development", 4);
        Course info7250 = courseCatalog.newCourse("info7250", "Engineering of Big-Data Systems", 4);
        Course info7390 = courseCatalog.newCourse("info7390", "Advances in Data Sciences and Architecture", 4);

        // Create Directory
        PersonDirectory pd = department.getPersonDirectory();
        StudentDirectory sd = department.getStudentDirectory();
        FacultyDirectory fd = department.getFacultyDirectory();

        // Create faculty profiles
        Person Person01 = pd.newPerson("d9963007-63a1-4dcb-8f94-80a9f73ca3bf", "Khaled Bugrara");
        Person Person02 = pd.newPerson("5b74ae13-9c44-4e13-b4c9-28f82e4e63d0", "Andrei Guschin");
        Person Person03 = pd.newPerson("e33e5ce6-596f-4aae-8a69-d03c09b5405e", "Dino Konstantopoulos");
        Person Person04 = pd.newPerson("a74d3e94-793f-4e23-b05d-6abfbd7b2cfc", "Nicholas Brown");
        Person Person05 = pd.newPerson("37d50421-66a3-4690-b316-89b21491aa90", "Yusuf Ozbek");

        FacultyProfile faculty01 = fd.newFacultyProfile(Person01);
        FacultyProfile faculty02 = fd.newFacultyProfile(Person02);
        FacultyProfile faculty03 = fd.newFacultyProfile(Person03);
        FacultyProfile faculty04 = fd.newFacultyProfile(Person04);
        FacultyProfile faculty05 = fd.newFacultyProfile(Person05);

        // Create Student profiles
        Person Person06 = pd.newPerson("f14b09a1-cc52-4e37-9f6e-1a58f174e501", "Alice Smith");
        Person Person07 = pd.newPerson("ce9e1a65-1f71-4b1a-9a11-398a91ea25e5", "Bob Johnson");
        Person Person08 = pd.newPerson("7f267740-6e76-47ac-b3c4-1e8b3780360e", "Charlie Davis");
        Person Person09 = pd.newPerson("dfc22d27-dffa-4f52-8a17-91eeb8cafc9e", "David Wilson");
        Person Person10 = pd.newPerson("a7d26c35-c953-4bdf-bba0-45f377b6f6d4", "Eve Anderson");
        Person Person11 = pd.newPerson("4e38eb7d-813a-49db-a44e-3e14b65b95ef", "Frank Martin");
        Person Person12 = pd.newPerson("79d29b70-3c41-4b36-8d33-21f8b17d72b0", "Grace Lee");
        Person Person13 = pd.newPerson("2c4d78e1-7a19-4534-b7cf-5c81e42bace9", "Helen White");
        Person Person14 = pd.newPerson("e8cc6d1a-562d-44a9-bc1b-216b22b4eaaa", "Ian Turner");
        Person Person15 = pd.newPerson("1a3e04cd-0e8d-4e3d-b9e2-c2b49678dbb7", "Julia Hall");

        // Create StudentProfile objects for each Person
        StudentProfile student01 = sd.newStudentProfile(Person06);
        StudentProfile student02 = sd.newStudentProfile(Person07);
        StudentProfile student03 = sd.newStudentProfile(Person08);
        StudentProfile student04 = sd.newStudentProfile(Person09);
        StudentProfile student05 = sd.newStudentProfile(Person10);
        StudentProfile student06 = sd.newStudentProfile(Person11);
        StudentProfile student07 = sd.newStudentProfile(Person12);
        StudentProfile student08 = sd.newStudentProfile(Person13);
        StudentProfile student09 = sd.newStudentProfile(Person14);
        StudentProfile student10 = sd.newStudentProfile(Person15);

        // Testing
        Transcript student01Transcript = student01.getTranscript();
        Transcript student02Transcript = student02.getTranscript();
        Transcript student03Transcript = student03.getTranscript();
        Transcript student04Transcript = student04.getTranscript();
        Transcript student05Transcript = student05.getTranscript();
        Transcript student06Transcript = student06.getTranscript();
        Transcript student07Transcript = student07.getTranscript();
        Transcript student08Transcript = student08.getTranscript();
        Transcript student09Transcript = student09.getTranscript();
        Transcript student10Transcript = student10.getTranscript();
        // CourseLoad student01Spring2023 = student01Transcript.newCourseLoad("Fall2023");
        // CourseLoad student01CurrentCourseLoad = student01.getCurrentCourseLoad();

        // Part 2 – Populating the model (cont.) (40 points)
        // • Create a course schedule for Fall 2023 semester
        // • Create course offerings for each course for the semester • Create 25 seats for each course offering
        // • Register students for the courses
        // • Assign teachers (faculty) to course offerings
        // • Assign grades to students

        // Create a course schedule for Fall 2023 semester
        CourseSchedule csFall2023 = department.newCourseSchedule("Fall2023");

        // Create course offerings for each course for the semester
        CourseOffer info5001offerFall2023 = csFall2023.newCourseOffer("info5001");
        CourseOffer info5002offerFall2023 = csFall2023.newCourseOffer("info5002");
        CourseOffer info5100offerFall2023 = csFall2023.newCourseOffer("info5100");
        CourseOffer info7250offerFall2023 = csFall2023.newCourseOffer("info7250");
        CourseOffer info7390offerFall2023 = csFall2023.newCourseOffer("info7390");

        // Register students for Course info5001offerFall2023
        CourseLoad student01Fall2023 = student01Transcript.newCourseLoad("Fall2023");
        CourseLoad student01CurrentCourseLoad = student01.getCurrentCourseLoad();
        // SeatAssignment seatAssignment01 = info5001offerFall2023.assignEmptySeat(student01CurrentCourseLoad);
        CourseLoad student02Fall2023 = student02Transcript.newCourseLoad("Fall2023");
        CourseLoad student02CurrentCourseLoad = student02.getCurrentCourseLoad();
        // SeatAssignment seatAssignment02 = info5001offerFall2023.assignEmptySeat(student02CurrentCourseLoad);

        // Register students for Course info5002offerFall2023
        CourseLoad student03Fall2023 = student03Transcript.newCourseLoad("Fall2023");
        CourseLoad student03CurrentCourseLoad = student03.getCurrentCourseLoad();
        // SeatAssignment seatAssignment03 = info5002offerFall2023.assignEmptySeat(student03CurrentCourseLoad);
        CourseLoad student04Fall2023 = student04Transcript.newCourseLoad("Fall2023");
        CourseLoad student04CurrentCourseLoad = student04.getCurrentCourseLoad();
        // SeatAssignment seatAssignment04 = info5002offerFall2023.assignEmptySeat(student04CurrentCourseLoad);

        // Register students for Course info5100offerFall2023
        CourseLoad student05Fall2023 = student05Transcript.newCourseLoad("Fall2023");
        CourseLoad student05CurrentCourseLoad = student05.getCurrentCourseLoad();
        // SeatAssignment seatAssignment05 = info5100offerFall2023.assignEmptySeat(student05CurrentCourseLoad);
        CourseLoad student06Fall2023 = student06Transcript.newCourseLoad("Fall2023");
        CourseLoad student06CurrentCourseLoad = student06.getCurrentCourseLoad();
        // SeatAssignment seatAssignment06 = info5100offerFall2023.assignEmptySeat(student06CurrentCourseLoad);

        // Register students for Course info7250offerFall2023
        CourseLoad student07Fall2023 = student07Transcript.newCourseLoad("Fall2023");
        CourseLoad student07CurrentCourseLoad = student07.getCurrentCourseLoad();
        // SeatAssignment seatAssignment07 = info7250offerFall2023.assignEmptySeat(student07CurrentCourseLoad);
        CourseLoad student08Fall2023 = student08Transcript.newCourseLoad("Fall2023");
        CourseLoad student08CurrentCourseLoad = student08.getCurrentCourseLoad();
        // SeatAssignment seatAssignment08 = info7250offerFall2023.assignEmptySeat(student08CurrentCourseLoad);

        // Register students for Course info7390offerFall2023
        CourseLoad student09Fall2023 = student09Transcript.newCourseLoad("Fall2023");
        CourseLoad student09CurrentCourseLoad = student09.getCurrentCourseLoad();
        // SeatAssignment seatAssignment09 = info7390offerFall2023.assignEmptySeat(student09CurrentCourseLoad);
        CourseLoad student10Fall2023 = student10Transcript.newCourseLoad("Fall2023");
        CourseLoad student10CurrentCourseLoad = student10.getCurrentCourseLoad();
        // SeatAssignment seatAssignment10 = info7390offerFall2023.assignEmptySeat(student10CurrentCourseLoad);

        // Create 25 seats for each course offering
        info5001offerFall2023.generateSeats(10);
        info5002offerFall2023.generateSeats(10);
        info5100offerFall2023.generateSeats(10);
        info7250offerFall2023.generateSeats(10);
        info7390offerFall2023.generateSeats(10);

        SeatAssignment seatAssignment01 = info5001offerFall2023.assignEmptySeat(student01CurrentCourseLoad);
        SeatAssignment seatAssignment02 = info5001offerFall2023.assignEmptySeat(student02CurrentCourseLoad);
        SeatAssignment seatAssignment03 = info5002offerFall2023.assignEmptySeat(student03CurrentCourseLoad);
        SeatAssignment seatAssignment04 = info5002offerFall2023.assignEmptySeat(student04CurrentCourseLoad);
        SeatAssignment seatAssignment05 = info5100offerFall2023.assignEmptySeat(student05CurrentCourseLoad);
        SeatAssignment seatAssignment06 = info5100offerFall2023.assignEmptySeat(student06CurrentCourseLoad);
        SeatAssignment seatAssignment07 = info7250offerFall2023.assignEmptySeat(student07CurrentCourseLoad);
        SeatAssignment seatAssignment08 = info7250offerFall2023.assignEmptySeat(student08CurrentCourseLoad);
        SeatAssignment seatAssignment09 = info7390offerFall2023.assignEmptySeat(student09CurrentCourseLoad);
        SeatAssignment seatAssignment10 = info7390offerFall2023.assignEmptySeat(student10CurrentCourseLoad);

        // Assign teachers (faculty) to course offerings
        // faculty01.AssignAsTeacher(info5001offerFall2023);
        // faculty02.AssignAsTeacher(info5002offerFall2023);
        // faculty03.AssignAsTeacher(info5100offerFall2023);
        // faculty04.AssignAsTeacher(info7250offerFall2023);
        // faculty05.AssignAsTeacher(info7390offerFall2023);

        info5001offerFall2023.AssignAsTeacher(faculty01);
        info5002offerFall2023.AssignAsTeacher(faculty02);
        info5100offerFall2023.AssignAsTeacher(faculty03);
        info7250offerFall2023.AssignAsTeacher(faculty04);
        info7390offerFall2023.AssignAsTeacher(faculty05);

        // Assign grades to students
        seatAssignment01.assignGrade(3.7f); // The f at the end of 3.7f is used to indicate that the number is a float literal
        seatAssignment02.assignGrade(4.0f);
        seatAssignment03.assignGrade(3.7f);
        seatAssignment04.assignGrade(4.0f);
        seatAssignment05.assignGrade(3.7f);
        seatAssignment06.assignGrade(4.0f);
        seatAssignment07.assignGrade(3.7f);
        seatAssignment08.assignGrade(4.0f);
        seatAssignment09.assignGrade(3.7f);
        seatAssignment10.assignGrade(4.0f);

        // Part 3 – Program Analytics (40 points)
        // • Implement a method to print the Course schedule showing all courses taught this semester showing Course information, teachers, number of registered students and remaining empty seats.
        System.out.println("------------------------------------------------------------");
        System.out.println("print the Course schedule showing all courses taught this semester showing Course information, teachers, number of registered students and remaining empty seats:");
        csFall2023.printCourseSchedule();

        // • Implement a method to calculate Department revenue (or use one if exists) for Fall 2023 semester showing breakdown by Course offerings.
        System.out.println("------------------------------------------------------------");
        System.out.println("Fall 2023 semester showing breakdown by Course offerings:");
        csFall2023.calculateAndPrintDepartmentRevenueBreakdown();
    }

}
