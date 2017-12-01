package eric.quiz2_2017.Q2;

import java.util.Vector;

public class Freshman implements Visitable {
    public String name;           // name of the student
    public String number;         // the student's number
    private Vector course_grades;  // courses taken by student
    private double gpa;  // grade point average

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Freshman(String nm, String no) {
        this.name = nm;
        this.number = no;
        this.course_grades = new Vector();
    }

    public void assignGrade(String course, String score) {
        Course c = new Course(course, score);
        course_grades.addElement(c);
    }

    public Vector getCourseGrades() {
        return this.course_grades;
    }

    public void putGpa(double g) {
        this.gpa = g;
    }

    public double getGpa() {
        return this.gpa;
    }
}