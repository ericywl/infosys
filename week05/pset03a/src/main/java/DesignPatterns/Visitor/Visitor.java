package DesignPatterns.Visitor;

public interface Visitor {
    void visit (Book b);
    void visit (CD c);
    void visit (Clothing c);
}
