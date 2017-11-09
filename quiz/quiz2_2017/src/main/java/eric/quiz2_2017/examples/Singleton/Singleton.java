package eric.quiz2_2017.examples.Singleton;

public class Singleton {
    private static Singleton instance = null;

    // if there's no instance, create new one
    // else return the instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    public void showMessage() {
        System.out.println("In Singleton:: showmessage()");
    }
}
