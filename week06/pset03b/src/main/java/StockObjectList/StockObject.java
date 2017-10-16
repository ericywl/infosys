package StockObjectList;

class StockObject {
    private String str;
    private int length;
    private StockObject next;
    private StockObject prev;

    StockObject(String str) {
        this.str = str;
        this.length = str.length();
        this.next = null;
        this.prev = null;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public StockObject getNext() {
        return next;
    }

    public void setNext(StockObject next) {
        this.next = next;
    }

    public StockObject getPrev() {
        return prev;
    }

    public void setPrev(StockObject prev) {
        this.prev = prev;
    }
}
