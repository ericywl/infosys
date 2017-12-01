package eric.quiz2_2015.Q2;


public class CountPeople {
    public static void main(String[] args) {
        NegativeCountException rc = new NegativeCountException();

        System.out.println("The constructor should give us an empty room");
        System.out.println("The count is " + rc.getCount());

        System.out.println("Add three people to the room ");
        rc.addPerson();
        rc.addPerson();
        rc.addPerson();
        System.out.println("The count is " + rc.getCount());

        try {
            System.out.println("Remove two people from the room ");
            rc.removePerson();
            rc.removePerson();
            System.out.println("The count is " + rc.getCount());

            System.out.println("Remove one person from the room ");
            rc.removePerson();
            System.out.println("The count is " + rc.getCount());

            System.out.println("Trying to remove another person from the room ");
            rc.removePerson();
            System.out.println("The count is " + rc.getCount());
        } catch (NegativeCountException e) {
            System.out.println("Caught an exception:: " + e.getMessage());
        }

    }
}

