package Part_A.DesignPatterns.TaxVisitor;

public class Chocolate implements Visitable {
    // Your code goes here
    private int amount;
    private final double[] taxPercentage = {0.2, 0.1};

    public Chocolate(int amount) {
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
