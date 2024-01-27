package Codewars;

/*
* A format for expressing an ordered list of integers is to use a comma separated list of either individual integers
* or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'.
* The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans at least 3 numbers.
* For example "12,13,15-17"
*/



public class RangeExtraction {

    public static void main(String[] args) {
        System.out.println(rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20}));
    }

    public static String rangeExtraction(int[] arr) {
        if (arr.length > 0) {
            int aux = 0;
            int auxL = 0;
            int auxR = 0;
            boolean inRange = false;
            String result = "";
            for (int i = 0; i < arr.length; i++) {
//                if (i < arr.length-1 && arr[i+1] - arr[i] > 2) { // si no va a formar rango
//                    result += arr[i] + ",";
//                    continue;
//                }
                if(i < arr.length-2 && arr[i+2] - arr[i] == 2) { // si va a formar rango
                    inRange = true;
                    auxL = arr[i];
                    while (i < arr.length-2 && arr[i+2] - arr[i] == 2) {
                        auxR = arr[i+2];
                        i++;
                    }
                    result += auxL + "-" + auxR + ",";
                    i++;
                    continue;
                }
                result += arr[i] + ",";
            }
            return result.substring(0, result.length()-1);
        }
        return "";
    }
}
