package Part_A.GrandTotalVisitor;

public class Fish implements Visitable {
    // Your code goes here
    private double subtotal;

    public Fish(int pricePerKg, int weight) {
        this.subtotal = pricePerKg * weight;
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

