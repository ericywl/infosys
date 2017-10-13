package DesignPatterns.TaxVisitor;

public interface Visitable {
    void accept(Visitor v);
    int getAmount();
    double[] getTaxPercentage();
}