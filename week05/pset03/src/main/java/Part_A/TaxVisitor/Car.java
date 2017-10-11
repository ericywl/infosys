package Part_A.TaxVisitor;

public class Car implements Visitable {
    // Your code goes here
    private int amount;
    private final double[] taxPercentage = {0.4, 0.3};

    public Car(int amount) {
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
