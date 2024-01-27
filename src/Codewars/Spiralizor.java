package Codewars;

import java.util.Arrays;

public class Spiralizor {

    public static void main(String[] args) {
        int[][] prueba5 = spiralize(5);
        int[][] prueba6 = spiralize(6);
        int[][] prueba7 = spiralize(7);
        int[][] prueba8 = spiralize(8);
        int[][] prueba10 = spiralize(10);
        for (int[] i : prueba6) {
            System.out.println(Arrays.toString(i));
        }
        for (int[] i : prueba7) {
            System.out.println(Arrays.toString(i));
        }
        for (int[] i : prueba8) {
            System.out.println(Arrays.toString(i));
        }
        for (int[] i : prueba10) {
            System.out.println(Arrays.toString(i));
        }

    }

    public static int[][] spiralize(int size) {
        int[][] innerMatrix = new int[size][size];
        int i = 0, j = 0;
        int distHor = 0;

        while (i < size - distHor && j < size - distHor) {
            while (j < size - distHor) { // right
                innerMatrix[i][j] = 1;
                j++;
            }
            j--;

            while (i < size - distHor) { // down
                innerMatrix[i][j] = 1;
                i++;
            }
            i--;

            while (j >= distHor) { // left
                innerMatrix[i][j] = 1;
                j--;
            }
            j++;


            distHor = distHor + 2;

            while (i >= distHor) { // up
                innerMatrix[i][j] = 1;
                i--;
            }
            i++;
        }
        if ((size - 2) % 4 == 0) {
            innerMatrix[size / 2][size / 2 - 1] = 0;
        }
        return innerMatrix;
    }
}

/* ESTO NO VALE PARA n = 6; intento rellenar todo de 0s
*     public static int[][] spiralize(int size) {
        int[][] innerMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                innerMatrix[i][j] = 1;
            }
        }
        innerMatrix [1][0] = 0;
        int i = 1, j = 1;
        int distHor = 2;
        boolean flag = false;

        while (!flag && i <= size - distHor && j <= size - distHor) {
            flag = true;

            while (j <= size - distHor){ // right
                innerMatrix[i][j] = 0;
                flag = false;
                j++;
            } j--;

            while (i <= size - distHor) { // down
                innerMatrix[i][j] = 0;
                flag = false;
                i++;
            } i--;

            while (j > distHor - 2) { // left
                innerMatrix[i][j] = 0;
                flag = false;
                j--;
            }j++;


            distHor = distHor + 2;

            while (i > distHor-2) { // up
                innerMatrix[i][j] = 0;
                flag = false;
                i--;
            } i++;
        }
            return innerMatrix;
        }
*/
