package eric.quiz2_2017.Q1;

import java.util.Comparator;

public class LineSlopeComparator implements Comparator<Line> {
    @Override
    public int compare(Line o1, Line o2) {
        if (o1.computeSlope() > o2.computeSlope()) {
            return 1;
        } else if (o1.computeSlope() < o2.computeSlope()) {
            return -1;
        } else {
            return 0;
        }
    }
}
