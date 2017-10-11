package Part_A.TaxVisitor;

public interface Visitable {
    void accept(Visitor v);
    int getAmount();
    double[] getTaxPercentage();
}