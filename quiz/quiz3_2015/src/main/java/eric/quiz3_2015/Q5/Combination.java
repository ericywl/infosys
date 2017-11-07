package eric.quiz3_2015.Q5;


public class Combination {
    public static String recurCombination(String[][] data, String[] oneline, int group) {
        if (data == null) return "";
        if (data.length == 0) return "";
        if (group >= data.length) return "";

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < data[group].length; i++) {
            oneline[group] = data[group][i];
            if (group == data.length - 1) {
                output.append(formatOut(oneline));
            }

            String temp = recurCombination(data, oneline, group + 1);
            output.append(temp);
        }

        return output.toString();
    }

    private static String formatOut(String[] oneline) {
        StringBuilder output = new StringBuilder();

        for (String s : oneline) {
            output.append(s);
            output.append(" ");
        }

        output.append("\n");
        return output.toString();
    }
}
