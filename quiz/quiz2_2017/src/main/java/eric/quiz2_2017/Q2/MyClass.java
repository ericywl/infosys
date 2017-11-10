package eric.quiz2_2017.Q2;

import java.util.ArrayList;

public class MyClass {
    public static void main(String args[]) {
        System.out.println("Hello World! This is the Visitor demo.");
        String[][] stugrades =
                   {{"Jimmy",    "2349-1",   "math1",  "C+",   "physics",   "B-",   "chemistry",    "A",   "hum-elective",    "A"},
                    {"Philip",   "5548-1",   "math2",   "C",   "chemistry", "A",   "biology",      "A",   "hum-elective",    "C"},
                    {"Joanna",   "1334-2",   "algo",    "C",   "compstruct","B",   "programming",  "C",   "database1",       "A"},
                    {"Kevin",    "1987-1",   "math1",   "A+",   "physics",   "A",   "biology",      "A",   "hum-elective",    "B"},
                    {"Tom",      "2501-3",   "graphics","C",   "security",  "B",   "networks2",    "A",   "UIdesign",        "A"},
                    {"Betty",    "2828-1",   "math2",   "B",   "physics",   "C",   "biology",      "C",   "hum-elective",    "B"},
                    {"Andy",     "1004-2",   "database1","C",  "networks1", "B",   "algo",         "A",   "hum-elective",    "A"},
                    {"Grace",    "3100-3",   "graphics", "A",   "security",  "A",   "UIdesign",     "A",   "hum-elective",    "C"},
                    {"Fletcher", "3182-2",   "algo",    "B",    "systems",   "B",   "database1",    "B",   "networks1",       "A"},
                    {"Braun",    "2301-2",   "compstruct",  "A",   "programming", "A",   "database1",      "B",   "algo",    "C"},
                    {"Belinda",  "1831-3",   "graphics", "B",    "security",      "A",   "UIdesign",       "A",   "hum-elective",    "C"},
                    {"Roger",    "4431-3",   "database2", "B",   "security",      "B",   "networks2",      "C",   "hum-elective",    "A"},
                    {"Dilbert",  "1588-2",   "database1", "B",   "programming",   "A",   "compstructs",    "A",   "networks1",       "C"},
                    {"Peter",    "2991-1",   "math2",    "A",    "physics",       "C",   "chemistry",      "B",   "hum-elective",    "B"},
                    {"Margaret", "3817-3",   "security", "C",    "database2",     "A",   "UIdesign",       "A",   "hum-elective",    "C"}}
                    ;

        ArrayList<Visitable> students = new ArrayList<Visitable>();

        GpaVisitor gpaVisitor = new GpaVisitor();
            for (int i=0; i < stugrades.length; i++) {
                String name = stugrades[i][0];
                String number = stugrades[i][1];
                if (number.substring(5).equalsIgnoreCase("1")){
                    Freshman stu = new Freshman(name, number);
                    students.add(stu);
                    stu.assignGrade(stugrades[i][2], stugrades[i][3]);
                    stu.assignGrade(stugrades[i][4], stugrades[i][5]);
                    stu.assignGrade(stugrades[i][6], stugrades[i][7]);
                    stu.assignGrade(stugrades[i][8], stugrades[i][9]);
                }
                if (number.substring(5).equalsIgnoreCase("2")) {
                    Sophomore stu = new Sophomore(name, number);
                    students.add(stu);
                    stu.assignGrade(stugrades[i][2], stugrades[i][3]);
                    stu.assignGrade(stugrades[i][4], stugrades[i][5]);
                    stu.assignGrade(stugrades[i][6], stugrades[i][7]);
                    stu.assignGrade(stugrades[i][8], stugrades[i][9]);
                }

                if (number.substring(5).equalsIgnoreCase("3")) {
                    Junior stu = new Junior(name, number);
                    students.add(stu);
                    stu.assignGrade(stugrades[i][2], stugrades[i][3]);
                    stu.assignGrade(stugrades[i][4], stugrades[i][5]);
                    stu.assignGrade(stugrades[i][6], stugrades[i][7]);
                    stu.assignGrade(stugrades[i][8], stugrades[i][9]);
                }
            }
            for (Visitable o : students) {
                o.accept(gpaVisitor);
            }
        System.out.println ("Average Freshman GPA = " + gpaVisitor.getAvgFreshmanGpa() + "/5 ");
        System.out.println ("Average Sophomore GPA = " + gpaVisitor.getAvgSophomoreGpa()+ "/4");
        System.out.println ("Average Junior GPA = " + gpaVisitor.getAvgJuniorGpa()+ "/4");

        AwardsVisitor awardsVisitor = new AwardsVisitor();
        for (Visitable o : students) {
            o.accept(awardsVisitor);
        }

    }
}
