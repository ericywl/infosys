package DesignPatterns.Proxy;

public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    // if image doesn't exist, go get it first
    // else display it immediately
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }

}
