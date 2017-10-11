package Part_A.DesignPatterns.Visitor;

public class Book implements Visitable {
    private double weight;

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Book(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

}
