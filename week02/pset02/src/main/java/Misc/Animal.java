package Misc;

public class Animal {
}

class Chicken extends Animal implements Eatable {
    @Override
    public String howToEat() {
        return "boil it";
    }
}

class Duck extends Animal implements Eatable {
    @Override
    public String howToEat() {
        return "fry it";
    }
}

class Dog extends Animal {
}
