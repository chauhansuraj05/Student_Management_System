import java.util.*;~

// Student class
class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}

// Main system class
public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // FIX: clear buffer

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewStudents();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter numbers only.");
                sc.nextLine(); // clear invalid input
            }
        }
    }

    // CREATE
    static void addStudent() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            // 🔥 FIX: Check duplicate ID
            for (Student s : students) {
                if (s.id == id) {
                    System.out.println("Student ID already exists!");
                    return;
                }
            }

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            if (age <= 0) {
                System.out.println("Invalid age!");
                return;
            }

            students.add(new Student(id, name, age));
            System.out.println("Student added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    // READ
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // UPDATE
    static void updateStudent() {
        try {
            System.out.print("Enter ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            for (Student s : students) {
                if (s.id == id) {

                    System.out.print("Enter new name: ");
                    s.name = sc.nextLine();

                    System.out.print("Enter new age: ");
                    int age = sc.nextInt();

                    if (age <= 0) {
                        System.out.println("Invalid age!");
                        return;
                    }

                    s.age = age;

                    System.out.println("Student updated successfully!");
                    return;
                }
            }

            System.out.println("Student not found!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    // DELETE
    static void deleteStudent() {
        try {
            System.out.print("Enter ID to delete: ");
            int id = sc.nextInt();

            Iterator<Student> iterator = students.iterator();

            while (iterator.hasNext()) {
                Student s = iterator.next();
                if (s.id == id) {
                    iterator.remove(); // safe removal
                    System.out.println("Student deleted successfully!");
                    return;
                }
            }

            System.out.println("Student not found!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }
}