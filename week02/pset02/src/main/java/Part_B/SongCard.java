package Part_B;
// Homework Question 3
// total: 15 points

//===============================================
// todo: complete the following program
//===============================================


public class SongCard {
    private int songs;
    private boolean activated;

    public SongCard(int n) {
        this.songs = n;
        this.activated = false;
    }

    public void activate() {
        this.activated = true;
    }

    public void buyASong()
            throws CardNotActivatedException, CardEmptyException {
        if (!this.activated) {
            throw new CardNotActivatedException();
        }

        if (this.songs == 0) {
            throw new CardEmptyException();
        }

        this.songs--;


    }

    public int songsRemaining() {
        return this.songs;

    }

    public String toString() {
        String notStr = "not";

        if (this.activated) {
            notStr = "";
        }
        return "Card has " + this.songs + " songs and is " + notStr + " activated";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SongCard sc = new SongCard(10);
        System.out.println(sc);
        System.out.println("\nTrying to buy a song");

        try {
            sc.buyASong();
        } catch (CardEmptyException e1) {
            System.out.println("Caught error: " + e1.getMessage());
        } catch (CardNotActivatedException e2) {
            System.out.println("Caught error: " + e2.getMessage());
        }

        System.out.println(sc);
        System.out.println("Activating the card");
        sc.activate();
        System.out.println(sc);

        System.out.println("\nBuying songs");
        for (int i = 0; i < 11; i++) {
            try {
                sc.buyASong();
                System.out.println("Bought a song: " + sc);
            } catch (CardEmptyException e1) {
                System.out.println("Caught error: " + e1.getMessage());
            } catch (CardNotActivatedException e2) {
                System.out.println("Caught error: " + e2.getMessage());
            }
        }

        System.out.println(sc);
    }

    public class CardNotActivatedException extends Exception {
        public String getMessage() {
            return "Card not activated";
        }

    }

    public class CardEmptyException extends Exception {
        public String getMessage() {
            return "No more songs on the card";
        }
    }
}
