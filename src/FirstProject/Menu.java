package FirstProject;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.List;
import java.util.Scanner;

public class Menu {
    static Student student;
    static Scanner sc=new Scanner(System.in);
    public static void menu(){
        while (true){
            System.out.println("+-----Welcome-------+");
            System.out.println("| 1.Add Student     |");
            System.out.println("| 2.View Student    |");
            System.out.println("| 3.Update Student  |");
            System.out.println("| 4.Delete Student  |");
            System.out.println("| 5.Exit            |");
            System.out.println("| Enter Your choice |");
            System.out.println("+--------------------+");
            int n=sc.nextInt();
            sc.nextLine();
            switch (n){
                case 1:
                    student=Functions.returnStudent();
                    StudentDatabaseInteraction.addStudent(student);
                    break;
                case 2:
                    List<Student> students = StudentDatabaseInteraction.getAllStudents();
                    Functions.printStudentTable(students);
                    break;
                case 3:
                    int id=Functions.getId();
                    StudentDatabaseInteraction.updateStudent(Functions.returnStudent(),id);
                    break;
                case 4:
                    int delete=Functions.getId();
                    StudentDatabaseInteraction.deleteStudent(delete);
                    break;
                case 5:
                    System.out.println("***********************");
                    System.out.println("*Exiting the System...*");
                    System.out.println("***********************");
                    System.exit(0);
                default:
                    System.out.println("Invalid Input");
                    break;

            }

        }
    }
}
