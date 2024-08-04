package FirstProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentDatabaseInteraction {
    private static final HashMap<Integer, Student> smap = new HashMap<>();

    public StudentDatabaseInteraction() {
        loadStudents();
    }

    private static void loadStudents() {
        String sql = "select * from student";
        try (Connection con = DatabaseConnection.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setCourse(resultSet.getString("course"));
                student.setCity(resultSet.getString("city"));
                student.setMarks(resultSet.getInt("totalMarks"));
                student.setPhone(resultSet.getString("phoneNo"));
                smap.put(student.getId(), student);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void addStudent(Student student) {
        String sql = "insert into student(name,course,city,totalMarks,phoneNo) values (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getCourse());
            ps.setString(3, student.getCity());
            ps.setInt(4, student.getMarks());
            ps.setString(5, student.getPhone());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                student.setId(generatedKeys.getInt(1));
                smap.put(student.getId(), student);
                System.out.println("Student Added Successfully !");
                System.out.println("---------------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static List<Student> getAllStudents() {
        loadStudents();
        return new ArrayList<>(smap.values());
    }

    public static void updateStudent(Student student,int id) {
        String sql = "update student set name = ?, course = ?, city = ?, totalMarks = ?, phoneNo = ? where id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getCourse());
            ps.setString(3, student.getCity());
            ps.setInt(4, student.getMarks());
            ps.setString(5, student.getPhone());
            ps.setInt(6, id);
            ps.executeUpdate();
            smap.put(student.getId(), student);
            System.out.println("Student Updated Successfully !");
            System.out.println("---------------------------------------------------");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void deleteStudent(int id) {
        String sql = "delete from student where id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            smap.remove(id);
            System.out.println("Student deleted Successfully !");
            System.out.println("---------------------------------------------------");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
