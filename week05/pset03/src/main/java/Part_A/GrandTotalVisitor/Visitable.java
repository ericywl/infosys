package Part_A.GrandTotalVisitor;

public interface Visitable {
    void accept(Visitor v);
    double getSubtotal();
}
