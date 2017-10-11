package Part_A.MessageBoard;

public class Test {
    public static void main(String[] args) {
        Topic topic50001 = new Topic();
        Subscriber scott = new Subscriber(topic50001);
        Subscriber roger = new Subscriber(topic50001);
        //note Attach takes place within constructor

        topic50001.postMessage("quiz tmr!!");

        Subscriber jit = new Subscriber(topic50001);
        topic50001.postMessage("exam next week!!");

        topic50001.unregister(jit);

        topic50001.postMessage("Great!! jit has gone!");

    }

}
