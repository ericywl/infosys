package eric.quiz3_2013.Q2;


public class CoffeMaker {
    private static final int tooCold = 55;
    private static final int tooHot = 85;

    public static void makeCoffee(int temperature) throws TooCold, TooHot {
        if (temperature <= tooCold) throw new TooCold();
        if (temperature >= tooHot) throw new TooHot();
    }

    public static String tasteCoffee(int tempCoffee) {
        try {
            makeCoffee(tempCoffee);
        } catch (TooCold ex) {
            return "Yuck!";
        } catch (TooHot ex) {
            return "Ouch!";
        }

        return "Mmm!";
    }

    public static void main(String[] args) {
        System.out.println(tasteCoffee(20));
        System.out.println(tasteCoffee(70));
        System.out.println(tasteCoffee(90));
    }
}

class TooCold extends Exception {}
class TooHot extends Exception {}
