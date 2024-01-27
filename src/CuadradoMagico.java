import java.io.BufferedReader;

public class CuadradoMagico {

    public static void main(String[] args) throws Exception {
        // j*n+i = index
        int n = 0;
        boolean diabolico = false, esoterico = false;
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            String[] numeros = br.readLine().split(" ");
            // las siguientes líneas cogen el anterior array y las convierten en un array de enteros
            int[] numerosInt = new int[numeros.length];
            for (int i = 0; i < numeros.length; i++) {
                numerosInt[i] = Integer.parseInt(numeros[i]);
            }
            // comprobamos si es diabolico o esoterico
            diabolico = isDiabolico(n, numerosInt);
            if (diabolico) {
                esoterico = isEsoterico(n, numerosInt);
            } else {
                System.out.println("NO");
            }

            if (diabolico) {
                if (esoterico) {
                    System.out.println("ESOTERICO");
                } else {
                    System.out.println("DIABOLICO");
                }

            }
            // reiniciamos las variables
            diabolico = false;
            esoterico = false;
        } // fin del while

    }

    private static boolean isDiabolico(int n, int[] numeros) {
        int cuadrado = n*n;
        int i, j;
        int sumaOG = 0;
        int aux = 0;
        for (i = 0; i < n; i++) {
            sumaOG += numeros[i];
        }
        // esto comprueba que las filas sean iguales
        for (i = n; i < cuadrado; i++) {
            for(j = 0; j < n; j++) {
                aux += numeros[i++];
            }
            i--;
            if (sumaOG != aux) {
                return false;
            }
            aux = 0;
        }
        // esto comprueba que las columnas sean iguales
        for (j = 0; j < n; j++) {
            aux = 0;
            for (i = 0; i < n; i++) {
                aux += numeros[i * n + j];
            }
            if (sumaOG != aux) {
                return false;
            }
        }
        // esto comprueba que las diagonales sean iguales

        return true;
    }

    private static boolean isEsoterico(int n, int[] numeros) {

        return false;
    }
}