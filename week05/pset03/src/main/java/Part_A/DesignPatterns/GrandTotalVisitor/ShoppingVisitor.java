package Part_A.DesignPatterns.GrandTotalVisitor;

public class ShoppingVisitor implements Visitor {
    private double total;

    // Your code goes here
    public double getTotal() {
        return total;
    }

    @Override
    public void visit(Milk m) {
        total += m.getSubtotal();
    }

    @Override
    public void visit(Fish f) {
        total += f.getSubtotal();
    }

    @Override
    public void visit(Jacket j) {
        total += j.getSubtotal();
    }
}
