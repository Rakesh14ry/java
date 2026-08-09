import student.Student;
import faculty.Faculty;

public class CollegeManagement {

    public static void main(String[] args) {

        Student s = new Student();
        Faculty f = new Faculty();

        System.out.println("Student Details:");
        s.displayStudent();

        System.out.println();

        System.out.println("Faculty Details:");
        f.displayFaculty();
    }
}