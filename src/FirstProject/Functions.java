package FirstProject;

import java.util.List;
import java.util.Scanner;

public class Functions {
    static Scanner s =new Scanner(System.in);

    public static Student returnStudent() {
        System.out.print("Enter name: ");
        String name = s.nextLine();
        System.out.print("Enter course: ");
        String course = s.nextLine();
        System.out.print("Enter city: ");
        String city = s.nextLine();
        System.out.print("Enter total marks: ");
        int marks = s.nextInt();
        s.nextLine();
        System.out.print("Enter phone number: ");
        String phone = s.nextLine();
        return new Student(name, course, city, marks, phone);
    }

    public static int getId() {
        System.out.println("Enter Id of student :");
        int n=s.nextInt();
        s.nextLine();
        return n;
    }
    //only the following code is taken form chatgpt for only good visuals of table.
    public static void printStudentTable(List<Student> students) {
        if (students == null || students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        String[] headers = {"ID", "Name", "Course", "City", "Total Marks", "Phone No"};
        int[] columnWidths = new int[headers.length];


        for (int i = 0; i < headers.length; i++) {
            columnWidths[i] = headers[i].length();
        }
        for (Student student : students) {
            columnWidths[0] = Math.max(columnWidths[0], String.valueOf(student.getId()).length());
            columnWidths[1] = Math.max(columnWidths[1], student.getName().length());
            columnWidths[2] = Math.max(columnWidths[2], student.getCourse().length());
            columnWidths[3] = Math.max(columnWidths[3], student.getCity().length());
            columnWidths[4] = Math.max(columnWidths[4], String.valueOf(student.getMarks()).length());
            columnWidths[5] = Math.max(columnWidths[5], student.getPhone().length());
        }
        printSeparator(columnWidths);
        printRow(headers, columnWidths);
        printSeparator(columnWidths);

        for (Student student : students) {
            String[] row = {
                    String.valueOf(student.getId()),
                    student.getName(),
                    student.getCourse(),
                    student.getCity(),
                    String.valueOf(student.getMarks()),
                    student.getPhone()
            };
            printRow(row, columnWidths);
        }

        printSeparator(columnWidths);
    }

    private static void printSeparator(int[] columnWidths) {
        System.out.print("+");
        for (int width : columnWidths) {
            for (int i = 0; i < width + 2; i++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
    }

    private static void printRow(String[] row, int[] columnWidths) {
        System.out.print("|");
        for (int i = 0; i < row.length; i++) {
            System.out.print(" " + padRight(row[i], columnWidths[i]) + " |");
        }
        System.out.println();
    }

    private static String padRight(String text, int length) {
        return String.format("%-" + length + "s", text);
    }

}

