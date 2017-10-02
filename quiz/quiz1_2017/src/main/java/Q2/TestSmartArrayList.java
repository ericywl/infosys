package Q2;

public class TestSmartArrayList {
    public static void main(String[] args) {
        SmartArrayList w = new SmartArrayList();
        w.add("hello");
        w.add("student");
        w.add(1, "dear");

        System.out.println(w);

        w.add(4, "java");
        w.add(3, "python");

        System.out.println(w);

        System.out.println(w.get(2));
        w.set(2,"instructor");
        w.remove(0);
        System.out.println(w);


        w.add(0,"nus");
        w.add(1,"ntu");
        w.add(0,"sutd");

        System.out.println(w);


    }
}


/*
output:

[hello,dear,student]
[hello,dear,student,python]
student
[dear,instructor,python]
[sutd,nus,ntu,dear,instructor,python]


 */