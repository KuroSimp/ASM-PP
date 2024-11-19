import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String fullName;
    int age;

    public Student(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{Name: " + fullName + ", Age: " + age + "}";
    }
}

public class SimpleStudentManagement {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add students");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit a student by full name");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    addStudents();
                    break;
                case 2:
                    findStudentsByLastName();
                    break;
                case 3:
                    findAndEditStudentByFullName();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    // 1. Thêm sinh viên vào danh sách
    static void addStudents() {
        System.out.print("Enter the number of students to add: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();
            int age = -1;
            // Kiểm tra đầu vào tuổi
            while (age < 0) {
                try {
                    System.out.print("Age: ");
                    age = Integer.parseInt(scanner.nextLine());
                    if (age < 0) {
                        System.out.println("Age cannot be negative. Please enter a valid age.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid number for age.");
                }
            }
            students.add(new Student(fullName, age));
        }
    }

    // 2. Tìm sinh viên theo họ
    static void findStudentsByLastName() {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();
        boolean found = false;

        for (Student student : students) {
            String[] nameParts = student.fullName.split(" ");
            if (nameParts[nameParts.length - 1].equalsIgnoreCase(lastName)) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found with last name: " + lastName);
        }
    }

    // 3. Tìm và sửa sinh viên theo tên đầy đủ
    static void findAndEditStudentByFullName() {
        System.out.print("Enter full name to search: ");
        String fullName = scanner.nextLine();
        boolean found = false;

        for (Student student : students) {
            if (student.fullName.equalsIgnoreCase(fullName)) {
                System.out.println("Found: " + student);

                // Sửa thông tin sinh viên
                System.out.print("Enter new full name: ");
                student.fullName = scanner.nextLine();
                int age = -1;
                while (age < 0) {
                    try {
                        System.out.print("Enter new age: ");
                        age = Integer.parseInt(scanner.nextLine());
                        if (age < 0) {
                            System.out.println("Age cannot be negative. Please enter a valid age.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a valid number for age.");
                    }
                }
                student.age = age;

                System.out.println("Updated: " + student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No student found with full name: " + fullName);
        }
    }
}
