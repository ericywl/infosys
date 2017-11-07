package eric.quiz2_2017.Q2;



public class SmartArrayList {
    private static final int INIT_CAPACITY = 2;
    public int size = 0;  // no of element stored
    private String[] data = new String[INIT_CAPACITY]; // where the element stored

    public SmartArrayList() {
    }

    public void add(int index, String s) {
        // check 0 <= index <= size
        // when index == size, append to the end
        if (index >= 0 && index <= size) {
            if (size + 1 > data.length) {
                String[] newData = new String[data.length * 2];
                for (int i = 0; i < data.length; i++) {
                    newData[i] = data[i];
                }

                data = newData;
            }

            if (index == size) {
                data[size] = s;
            } else {
                for (int i = size; i > index; i--) {
                    data[i] = data[i - 1];
                }

                data[index] = s;
            }

            size++;
        }
    }

    public void add(String s) {
        add(size, s);
    }

    public String get(int index) {
        if (index >= 0 && index < size) {
            return data[index];
        }

        return null;
    }

    public void set(int index, String s) {
        if (index >= 0 && index < size) {
            data[index] = s;
        }
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
    }

    @Override
    public String toString() {
        String output = "[";

        for (int i = 0; i < size; i++) {
            output += data[i];

            if (i < size - 1) {
                output += ",";
            }
        }

        output += "]";

        return output;
    }


}

