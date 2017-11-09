package eric.quiz2_2017.examples.State;

public class StatePatternDemo {
    public static void main (String[] args) {
        Context context = new Context();
        System.out.println(context);

        context.doAction();
        System.out.println(context);
        context.doAction();
        System.out.println(context);
    }
}
