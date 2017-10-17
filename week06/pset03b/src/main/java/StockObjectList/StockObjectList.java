package StockObjectList;


import java.util.Scanner;

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
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }

        StockObject temp = start;

        while (temp != end) {
            System.out.print(temp.getStr() + " Header: " + temp.getLength() + " <-> ");
            temp = temp.getNext();
        }

        System.out.println(end.getStr() + " Header: " + end.getLength());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        StockObjectList sol = new StockObjectList();
        char ch;
        System.out.println("StockObjectList Test");

        do {
            System.out.println("\nStockObjectList Operations\n");
            System.out.println("1. enterObject");
            System.out.println("2. displayObject");
            System.out.println("3. dumpObjects");
            System.out.println("4. isEmpty");

            System.out.print("Enter the operation code: ");
            int choice = reader.nextInt();
            reader.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter string element to insert: ");
                    String data = reader.nextLine();
                    sol.enterObject(data);
                    break;

                case 2:
                    System.out.print("Enter position of element to be displayed: ");
                    int pos = reader.nextInt();
                    System.out.print("Element: ");
                    sol.displayObject(pos);
                    break;

                case 3:
                    System.out.println("Dumping objects...");
                    sol.dumpObjects();
                    break;

                case 4:
                    System.out.println("Checking if list is empty...");
                    System.out.println(sol.isEmpty());
                    break;

                default:
                    System.out.println("That is not a valid operation.");
                    break;
            }

            System.out.print("\nDo you wish to continue (Type y or n): ");
            ch = reader.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');

    }
}
