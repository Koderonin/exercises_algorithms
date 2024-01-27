package Codewars;
/*
* Complete the solution so that it strips all text that follows any of a set of comment markers passed in. Any whitespace at the end of the line should also be stripped out.
*
* Example:
*
* Given an input string of:
*
* apples, pears # and bananas
* grapes
* bananas !apples
*
* The output expected would be:
*
* apples, pears
* grapes
* bananas
* */

public class StripComments {

    public static void main(String[] args) {
        System.out.println(stripComments( "apples, pears # and bananas  \ngrapes\nbananas   !apples", new String[] { "#", "!" }));
    }

    public static String stripComments(String text, String[] commentSymbols) {
        if (text == null || text.isEmpty() || commentSymbols == null || commentSymbols.length == 0) {
            return text;
        }
        String[] lines = text.split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (String symbol : commentSymbols) {
                if (lines[i].contains(symbol)) {
                    lines[i] = lines[i].substring(0, lines[i].indexOf(symbol));
                }
                lines[i] = lines[i].stripTrailing();
            }
        }
        return String.join("\n", lines);
    }
}
