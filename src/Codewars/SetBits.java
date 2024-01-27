package Codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetBits {

    public static void main(String[] args) {
        System.out.println(eliminateUnsetBits("11010101010101"));
    }
    public static long eliminateUnsetBits(String number) {
        if (number == null || number.length() == 0) {
            return 0L;
        }
        number = number.replace("0", "");
        return Long.parseLong(number,2);
    }
}
