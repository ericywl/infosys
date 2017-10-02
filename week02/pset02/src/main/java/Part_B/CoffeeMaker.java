package Part_B;
// Cohort Question 2
// total: 5 points

//===============================================
// todo: complete the following program
//===============================================

public class CoffeeMaker {
    private static final int tooCold = 55;
    private static final int tooHot = 85;

    public void makeCoffee(int temperature) throws TooCold, TooHot {
        if (temperature <= tooCold) throw new TooCold();
        if (temperature >= tooHot) throw new TooHot();
        System.out.println("Mmm!");
    }

    public static void main(String[] args) {
        CoffeeMaker c = new CoffeeMaker();
        int temperature[] = {20, 90, 60};
        for (int i = 0; i < 3; i++) {
            try {
                c.makeCoffee(temperature[i]);
            } catch (TooCold ex) {
                System.out.println("Yuck!");
            } catch (TooHot ex) {
                System.out.println("Ouch!");
            }
        }
    }
}

class TooCold extends Exception {

}

class TooHot extends Exception {
}
