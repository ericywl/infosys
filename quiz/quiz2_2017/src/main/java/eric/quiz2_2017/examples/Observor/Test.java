package eric.quiz2_2017.examples.Observor;

public class Test {
    public static void main(String[] args) {
        Topic topic50001 = new Topic();

        // subscribing to topic happens in constructor
        Subscriber scott = new Subscriber(topic50001);
        Subscriber roger = new Subscriber(topic50001);
        topic50001.postMessage("quiz tmr!!");

        // add new subscriber
        Subscriber jit = new Subscriber(topic50001);
        topic50001.postMessage("exam next week!!");
        topic50001.unregister(jit);

        topic50001.postMessage("Great!! jit has gone!");

    }

}
