package Part_A.DesignPatterns.GrandTotalVisitor;

public class Jacket implements Visitable {
    // Your code goes here
    private double subtotal;

    public Jacket(int price) {
        this.subtotal = price * 1.2;
    }

    @Override
    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

