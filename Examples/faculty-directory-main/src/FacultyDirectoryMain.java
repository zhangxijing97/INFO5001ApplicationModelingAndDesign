import model.Faculty;
import model.FacultyDirectory;

public class FacultyDirectoryMain {
    public static void main(String[] args) throws Exception {
        
        FacultyDirectory directory = new FacultyDirectory();

        directory.addNewFaculty("Archil", "Assistant Professor", "Information Systems", "alelashvili@northeastern.edu");
        directory.addNewFaculty("Prof Kal", "Program Director", "Information Systems", "profkal@northeastern.edu");
        directory.addNewFaculty("Prof Dino", "Teaching Professor", "Information Systems", "dino@northeastern.edu");
        directory.addNewFaculty("Prof Yusuf", "Teaching Professor", "Information Systems", "yusuf@northeastern.edu");

        directory.printFacultyList();

        // System.out.println(archil.getFullName());
        // System.out.println(archil.getPosition());


    }
}
