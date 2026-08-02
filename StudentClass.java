public class StudentClass {
    String name;
    int prn;

    StudentClass() {
        name = "Unknown";
        prn = 0;
    }

    StudentClass(String name, int prn) {
        this.name = name;
        this.prn = prn;
    }

    void display() {
        System.out.println("name=" + name);
        System.out.println("prn=" + prn);
    }

    public static void main(String[] args) {
        StudentClass s1 = new StudentClass();
        s1.name="Rakesh";
        s1.prn=101;
        System.out.println("student 1 detail:");
        s1.display();
        System.out.println("\nStudent 2 detail:");
        StudentClass s2 = new StudentClass();
        s2.display();
        
    }
}

