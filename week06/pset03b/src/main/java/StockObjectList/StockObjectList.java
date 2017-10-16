package StockObjectList;


public class StockObjectList {
    private StockObject start;
    private StockObject end;
    private int size;

    public StockObjectList() {
        start = null;
        end = null;
        size = 0;
    }

    public void enterObject(String str) {
        StockObject so = new StockObject(str);
        StockObject current = start;

        if (isEmpty()) {
            start = so;
            end = so;
            size++;
        } else {
            if (so.getLength() < start.getLength()) {
                so.setNext(start);
                start.setPrev(so);
                start = so;
                size++;
                return;
            }

            if (so.getLength() >= end.getLength()) {
                so.setPrev(end);
                end.setNext(so);
                end = so;
                size++;
                return;
            }

            while (true) {
                if (so.getLength() >= current.getLength()) {
                    current = current.getNext();
                } else {
                    StockObject temp = current.getPrev();
                    so.setNext(current);
                    current.setPrev(so);
                    temp.setNext(so);
                    so.setPrev(temp);
                    size++;
                    return;
                }
            }
        }
    }

    public void displayObject(int pos) {
        if (pos < 0 || pos > size - 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 0) {
            System.out.println(start.getStr());
            return;
        }

        if (pos == size - 1) {
            System.out.println(end.getStr());
            return;
        }

        StockObject temp = start;

        for (int i = 0; i < pos; i++) {
            temp = temp.getNext();
        }

        System.out.println(temp.getStr());
    }

    public void dumpObjects() {
        if (size == 0) {
            System.out.println("Empty");
            return;
        }

        StockObject temp = start;

        while (temp != end) {
            System.out.print(temp.getStr() + " Header: " + temp.getLength() + " <-> ");
            temp = temp.getNext();
        }

        System.out.println(end.getStr());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        StockObjectList sol = new StockObjectList();
        sol.enterObject("Spanner 6 Inch");
        sol.enterObject("D");
        sol.enterObject("Screw Driver");
        sol.enterObject("McDonalds");
        sol.enterObject("James");
        sol.enterObject("Blablabla");

        sol.dumpObjects();

        sol.displayObject(5);
    }
}
