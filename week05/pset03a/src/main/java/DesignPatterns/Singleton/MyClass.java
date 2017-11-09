package DesignPatterns.Singleton;

public class MyClass {
     public static void main (String[] args) {
         System.out.println("In main,");
         Singleton sTon = Singleton.getInstance();
         sTon.showMessage();
     }
}

