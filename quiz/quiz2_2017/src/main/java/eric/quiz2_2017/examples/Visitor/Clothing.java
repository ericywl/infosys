package eric.quiz2_2017.examples.Visitor;

public class Clothing implements Visitable {
    private double weight;

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Clothing(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

}