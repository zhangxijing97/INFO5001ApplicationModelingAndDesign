import model.Faculty;
import model.FacultyDirectory;

public class FacultyDirectoryMain {
    public static void main(String[] args) throws Exception {

        // Faculty xijing = new Faculty("Xijing Zhang", "Pro", "Math");
        // xijing.setName("Xijing Zhang");

        // System.out.println(xijing.getName());
        // System.out.println(xijing.getPostion());

        FacultyDirectory directory = new FacultyDirectory();
        Faculty xijing = directory.addNewFaculty("Harry Zhang", "ProPro", "Math");
        System.out.println(xijing.getPostion());
        System.out.println(xijing.getName());

        directory.addNewFaculty("Xijing Zhang", "ProPro", "Math");
        directory.printFacultyList();

        System.out.println("000");
        System.out.println("110");


    }
}
