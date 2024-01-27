package Codewars;
/* https://www.codewars.com/kata/5270d0d18625160ada0000e4
Greed is a dice game played with five six-sided dice. Your mission, should you choose to accept it, is to score a throw according to these rules. You will always be given an array with five six-sided dice values.

 Three 1's => 1000 points
 Three 6's =>  600 points
 Three 5's =>  500 points
 Three 4's =>  400 points
 Three 3's =>  300 points
 Three 2's =>  200 points
 One   1   =>  100 points
 One   5   =>   50 point

A single die can only be counted once in each roll. For example, a given "5" can only count as part of a triplet (contributing to the 500 points) or as a single 50 points, but not both in the same roll.

Example scoring

 Throw       Score
 ---------   ------------------
 5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
 1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
 2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)

* */

import java.util.HashMap;
import java.util.Map;

public class Greed {

    public static void main(String[] args) {
        int[] dice = {5, 1, 3, 4, 1};
        int[] dice2 = {1, 1, 1, 3, 1};
        int[] dice3 = {2, 4, 4, 5, 4};
        System.out.println(greedy(dice));
        System.out.println(greedy(dice2));
        System.out.println(greedy(dice3));
    }

    public static int greedy(int[] dice){
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : dice) {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }
        int sum = 0;
        int numDice;
        for (Map.Entry<Integer, Integer> d : map.entrySet()) {
            numDice = d.getValue();
            if(numDice >= 3) {
                switch (d.getKey()) {
                    case 2:
                        sum += 200;
                        break;
                    case 3:
                        sum += 300;
                        break;
                    case 4:
                        sum += 400;
                        break;
                    case 6:
                        sum += 600;
                        break;
                }
            }
        }
        if (map.get(1) != null) {
            if (map.get(1) >= 3) {
                sum += 1000;
                map.put(1, map.get(1) - 3);
            }sum += map.get(1) * 100;
        }
        if (map.get(5) != null) {
            if (map.get(5) >= 3) {
                sum += 500;
                map.put(5, map.get(5) - 3);
            }sum += map.get(5) * 50;
        }
        return sum;
    }
    // ésta es la buena
    public static int greedy2(int[] dice) {
        int[] n = new int[7];
        for (int d : dice)
            n[d]++;
        return n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;
    }
}
