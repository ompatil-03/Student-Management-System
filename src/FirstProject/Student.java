package FirstProject;
public class Student {
    private String name;
    private String course;
    private String city;
    private int id;
    private int marks;
    private String phone;
    public Student(){
        name=null;
        course=null;
        city=null;
        marks=-1;
        phone=null;
    }
    public Student(String name, String course, String city, int marks, String phone) {
        this.name = name;
        this.course = course;
        this.city = city;
        this.marks = marks;
        this.phone = phone;
    }
    @Override
    public String toString(){
        return "| "+this.id+"  |\t\t"+this.name+"  |     "+this.course+"    |    "+this.city+"   |     "+this.marks+"   |    "+this.phone+"  |";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
