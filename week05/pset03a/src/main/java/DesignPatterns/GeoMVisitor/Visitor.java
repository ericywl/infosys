package DesignPatterns.GeoMVisitor;

public interface Visitor {
    void visit(Circle c);
    void visit(Square s);
    void visit(Rectangle r);
}

