package eric.quiz2_2017.Q2;

public class AwardsVisitor implements Visitor {
    @Override
    public void visit(Freshman f) {
        double gpa = f.getGpa();
        if (gpa >= 4.5) {
            System.out.println("AWARD!!! Freshman: " + f.name + ", GPA: " + gpa + "/5");
        }
    }

    @Override
    public void visit(Sophomore s) {
        double gpa = s.getGpa();
        if (gpa >= 3.5) {
            System.out.println("AWARD!!! Sophomore: " + s.name + ", GPA: " + gpa + "/4");
        }
    }

    @Override
    public void visit(Junior j) {
        double gpa = j.getGpa();
        if (gpa >= 3.5) {
            System.out.println("AWARD!!! Junior: " + j.name + ", GPA: " + gpa + "/4");
        }
    }
}