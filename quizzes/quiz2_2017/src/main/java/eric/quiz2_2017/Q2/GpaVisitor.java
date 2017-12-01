package eric.quiz2_2017.Q2;

import java.util.Enumeration;
import java.util.Vector;

public class GpaVisitor implements Visitor {

    private double totalfreshmangpa = 0,
            totalsophomoregpa = 0,
            totaljuniorgpa = 0;

    private int numfreshman = 0,
            numsophomore = 0,
            numjunior = 0;

    @Override
    public void visit(Freshman f) {
        //System.out.println("Visiting Freshman: " + f.name);
        numfreshman += 1;
        int num = 0; // number of courses taken by student
        double total = 0; // total of grades earned by student
        double grade = 0; //quantitative value of letter grade

        Vector temp = f.getCourseGrades();
        for (Enumeration e = temp.elements(); e.hasMoreElements(); ) {
            Course c = (Course) e.nextElement();
            double cGrade = letterGradeToNumFreshman(c.getCourseGrade());

            num++;
            total += cGrade;
        }

        double gpa = total / num;
        f.putGpa(gpa);

        totalfreshmangpa += gpa;
    }

    @Override
    public void visit(Sophomore s) {
        //System.out.println("Visiting Sophomore: " + s.name);
        numsophomore += 1;
        int num = 0; // number of courses taken by student
        double total = 0; // total of grades earned by student
        double grade = 0; //quantitative value of letter grade

        Vector temp = s.getCourseGrades();
        for (Enumeration e = temp.elements(); e.hasMoreElements(); ) {
            Course c = (Course) e.nextElement();
            double cGrade = letterGradeToNum(c.getCourseGrade());

            num++;
            total += cGrade;
        }

        double gpa = total / num;
        s.putGpa(gpa);

        totalsophomoregpa += gpa;
    }

    @Override
    public void visit(Junior j) {
        //System.out.println("Visiting Junior: " + j.name);
        numjunior += 1;
        int num = 0; // number of courses taken by student
        double total = 0; // total of grades earned by student
        double grade = 0; //quantitative value of letter grade

        Vector temp = j.getCourseGrades();
        for (Enumeration e = temp.elements(); e.hasMoreElements(); ) {
            Course c = (Course) e.nextElement();
            double cGrade = letterGradeToNum(c.getCourseGrade());

            num++;
            total += cGrade;
        }

        double gpa = total / num;
        j.putGpa(gpa);

        totaljuniorgpa += gpa;
    }

    public double letterGradeToNumFreshman(String s) {
        double grade = 0;
        if (s.equalsIgnoreCase("a+")) grade = 5.3;
        else if (s.equalsIgnoreCase("a")) grade = 5.;
        else if (s.equalsIgnoreCase("a-")) grade = 4.7;
        else if (s.equalsIgnoreCase("b+")) grade = 4.3;
        else if (s.equalsIgnoreCase("b")) grade = 4.;
        else if (s.equalsIgnoreCase("b-")) grade = 3.7;
        else if (s.equalsIgnoreCase("c+")) grade = 3.3;
        else if (s.equalsIgnoreCase("c")) grade = 3.;
        else if (s.equalsIgnoreCase("c-")) grade = 2.7;
        else if (s.equalsIgnoreCase("d")) grade = 2.;
        return grade;
    }

    public int letterGradeToNum(String s) {
        int grade = 0;
        if (s.equalsIgnoreCase("a")) grade = 4;
        else if (s.equalsIgnoreCase("b")) grade = 3;
        else if (s.equalsIgnoreCase("c")) grade = 2;
        else if (s.equalsIgnoreCase("b")) grade = 1;
        return grade;
    }

    public double getAvgFreshmanGpa() {
        return totalfreshmangpa / numfreshman;
    }

    public double getAvgSophomoreGpa() {
        return totalsophomoregpa / numsophomore;
    }

    public double getAvgJuniorGpa() {
        return totaljuniorgpa / numjunior;
    }
}

