import java.util.ArrayList;

public class ToDoList {

    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<>();

        
        tasks.add("Complete Java Assignment");
        tasks.add("Study for Exam");
        tasks.add("Submit Project");

    
        tasks.remove("Study for Exam");

        
        StringBuffer sb = new StringBuffer();
        sb.append("To-Do List:\n");

        for (String task : tasks) {
            sb.append(task).append("\n");
        }

        System.out.println(sb);
    }
}