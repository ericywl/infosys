package DesignPatterns.FlyWeight;

import java.util.Locale;

public class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        String output = String.format(Locale.ENGLISH,
                "Circle: Draw() [Color: %s, x: %d, y: %d, radius: %d]",
                color, x, y, radius);

        System.out.println(output);
    }
}
