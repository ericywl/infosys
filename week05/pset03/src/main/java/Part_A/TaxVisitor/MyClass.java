package Part_A.TaxVisitor;
import java.util.ArrayList;

public class MyClass {
    public static void main (String[] args) {
        System.out.println("This is the Tax Visitor program. Total tax:");

        ArrayList<Visitable> items = new ArrayList<Visitable>();
        TaxVisitor tax = new TaxVisitor("TAXHOLIDAY");

        items.add(new Car(100000));
        items.add(new Electronics(2000));
        items.add(new Chocolate(100));

        for (Visitable o : items) {
            o.accept(tax);
        }
        System.out.println (tax.getTotal());
    }
}
