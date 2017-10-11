package Part_A.DesignPatterns.Visitor;

import java.util.ArrayList;


public class MyClass {
    public static void main(String[] args) {
        System.out.println("Hello World! This is the Visitor demo.");

        ArrayList<Visitable> items = new ArrayList<Visitable>();
        PostageVisitor postage = new PostageVisitor();
        items.add(new Book(1));
        items.add(new CD("psy"));
        items.add(new Book(2));
        items.add(new Clothing(10));

        for (Visitable o : items) {
            o.accept(postage);
        }
        System.out.println(postage.getTotal());
    }
}


