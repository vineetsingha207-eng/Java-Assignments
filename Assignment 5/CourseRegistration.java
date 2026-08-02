import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> courses = new ArrayList<>();

        System.out.print("enter number of courses: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("enter course name: ");
            courses.add(sc.nextLine());
        }
        System.out.print("enter course to remove: ");
        String remove = sc.nextLine();
        courses.remove(remove);

        System.out.println("removed course: " + remove);

        StringBuffer list = new StringBuffer();
        list.append("\nregistered courses:\n");

        for (int i = 0; i < courses.size(); i++) {
            list.append((i + 1) + ". " + courses.get(i) + "\n");
        }
        System.out.println(list);
        sc.close();
    }
}


