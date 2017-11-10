package eric.quiz2_2017.Q2;

public interface Visitor {
    void visit(Freshman f);
    void visit(Sophomore s);
    void visit(Junior j);
}
