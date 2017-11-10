package eric.quiz2_2017.Q2;
public class Course {
    String course_name;
    String grade;
    public Course(String nm, String gr) {
        course_name = nm;
        grade = gr;
    }
    public String getCourseName() { return course_name; }
    public String getCourseGrade() { return grade; }
}