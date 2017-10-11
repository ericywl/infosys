package Part_A.DesignPatterns.GrandTotalVisitor;

public interface Visitable {
    void accept(Visitor v);
    double getSubtotal();
}
