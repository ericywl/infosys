package DesignPatterns.TaxVisitor;

public class Electronics implements Visitable {
    // Your code goes here
    private int amount;
    private final double[] taxPercentage = {0.8, 0.5};

    public Electronics(int amount) {
        this.amount = amount;
    }

    @Override
    public double[] getTaxPercentage() {
        return taxPercentage;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
