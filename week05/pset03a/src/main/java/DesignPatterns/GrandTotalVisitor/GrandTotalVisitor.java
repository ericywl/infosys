package DesignPatterns.GrandTotalVisitor;

import java.util.ArrayList;

public class GrandTotalVisitor {
    public static void main (String[] args) {
        System.out.println("Hello World! This is the Visitor demo.");

        ArrayList<Visitable> items = new ArrayList<>();
        ShoppingVisitor postage = new ShoppingVisitor();
        items.add(new Milk(10));
        items.add(new Fish(4, 2));
        items.add(new Jacket(20));

        for (Visitable o : items) {
            o.accept(postage);
        }

        System.out.println(postage.getTotal());

    }

}
