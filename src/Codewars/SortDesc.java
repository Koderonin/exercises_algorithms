package Codewars;

public class SortDesc {

    public static void main(String[] args) {
        System.out.println(sortDesc(154756) == 765541);
    }

    public static int sortDesc(final int num) {
        String stringNum = String.valueOf(num);
        int[] arrayNum = new int[stringNum.length()];
        for (int i = 0 ; i < stringNum.length() ; i++){
            arrayNum[i] = Integer.parseInt(String.valueOf(stringNum.charAt(i)));
        }
        mergeSort(arrayNum);
        StringBuilder sortedNumber = new StringBuilder();
        for (int i = 0 ; i < arrayNum.length ; i++){
            sortedNumber.append(arrayNum[i]);
        }
        return Integer.parseInt(sortedNumber.toString());
    }

    public static void mergeSort(int[] arrayNum) {
        int size = arrayNum.length;
        if (size < 2) return;

        int half = size / 2;
        int[] left = new int[half];

        int i;
        for (i = 0 ; i < half ; i++){
            left[i] = arrayNum[i];
        }

        int[] right = new int[size - half];
        for (i = half ; i < size ; i++){
            right[i - half] = arrayNum[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arrayNum, left, right, half, size-half);
    }

    public static void merge(int[] arrayNum, int[] left,int[] right, int l_size, int r_size){
        int i = 0, j = 0, k = 0;
        while (i < l_size & j < r_size){
            if(left[i] > right[j]){
                arrayNum[k++] = left[i++];
            } else {
                arrayNum[k++] = right[j++];
            }
        }

        while (i < l_size) {
            arrayNum[k++] = left[i++];
        }

        while (j < r_size) {
            arrayNum[k++] = right[j++];
        }
    }
}
