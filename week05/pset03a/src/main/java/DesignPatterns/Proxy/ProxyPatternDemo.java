package DesignPatterns.Proxy;

public class ProxyPatternDemo {
    public static void main (String[] args) {
        // requesting image from proxy
        Image image = new ProxyImage("test_10mb.jpg");

        // image will be loaded from disk
        image.display();
        System.out.println("");

        // image will be displayed immediately
        image.display();
    }
}
