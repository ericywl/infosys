package Part_A.Singleton;

public class MyClass {
     public static void main (String[] args) {
         System.out.println("In main,");
         Singleton S = Singleton.getInstance();
         S.showMessage();
     }
}

