package Part_A.TaxVisitor;

public class TaxVisitor implements Visitor {
    // Your code goes here
    private String name;
    private double total;

    public TaxVisitor(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public void visit(Car c) {
        double taxAmount;

        if (name.toLowerCase().equals("taxholiday")) {
             taxAmount = c.getAmount() * c.getTaxPercentage()[1];
        } else {
            taxAmount = c.getAmount() * c.getTaxPercentage()[0];
        }

        total += taxAmount;
    }

    @Override
    public void visit(Electronics e) {
        double taxAmount;

        if (name.toLowerCase().equals("taxholiday")) {
            taxAmount = e.getAmount() * e.getTaxPercentage()[1];
        } else {
            taxAmount = e.getAmount() * e.getTaxPercentage()[0];
        }

        total += taxAmount;
    }

    @Override
    public void visit(Chocolate c) {
        double taxAmount;

        if (name.toLowerCase().equals("taxholiday")) {
            taxAmount = c.getAmount() * c.getTaxPercentage()[1];
        } else {
            taxAmount = c.getAmount() * c.getTaxPercentage()[0];
        }

        total += taxAmount;
    }
}


