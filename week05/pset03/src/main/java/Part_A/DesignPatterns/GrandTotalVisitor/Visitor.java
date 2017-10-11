package Part_A.DesignPatterns.GrandTotalVisitor;

public interface Visitor {
    double getTotal();
    void visit(Milk m);
    void visit(Fish f);
    void visit(Jacket j);
}
