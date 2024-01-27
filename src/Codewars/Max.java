package Codewars;

public class Max {
    public static int sequence(int[] arr) {
        if (arr.length == 0)
            return 0;
        //quiero devolver el valor de la suma de los valores del subarray cuya suma sea la más grande
        //ejemplo: arr = {1, 2, 3, 4, 5} -> max = 15
        //ejemplo: arr = {1, 2, 3, 4, 5, 6} -> max = 21
        //ejemplo: arr = {-1, 2, -3, 4, 5, -6, 7} -> max = 16
        int sum = 0;
        int max = 0;
        int pivoteLeft = 0;
        int pivoteRight = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            if (arr[i] < 0)
                continue;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > max){
                    max = sum;
                    //pivoteRight = j;
                }
            }
        }
        return max;
    }
    /*
    * public static int sequence(int[] arr) {
        int max_ending_here = 0, max_so_far = 0;
        for (int v : arr) {
            max_ending_here = Math.max(0, max_ending_here + v);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
    * */
}
