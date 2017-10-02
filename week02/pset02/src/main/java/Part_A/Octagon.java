package Part_A;
// Question 1
// total: 10 points

//===============================================
// todo: Modify Octagon class to implement the Comparable<Octagon> interface
//===============================================


public class Octagon implements Comparable<Octagon>{
    private double side;

    public Octagon(double side){
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public int compareTo(Octagon octagon) {
        if (this.getSide() > octagon.getSide()) {
            return 1;
        } else if (this.getSide() < octagon.getSide()) {
            return -1;
        } else {
            return 0;
        }
    }
}