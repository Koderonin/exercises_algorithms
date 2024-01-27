
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class embalse {

//    static int distancia;
//    public static void main(String[] args) {
//        Scanner leer = new Scanner(System.in);
//        distancia = leer.nextInt();
//        boolean salir;
//        int totalAgua;
//        int alturaPueblo;
//        while (distancia != 0){
//            totalAgua = 0;
//            alturaPueblo = 0;
//            for (int i = 0; i < distancia - 1; i++) {
//                totalAgua += leer.nextInt();
//            }
//            alturaPueblo = leer.nextInt();
//            totalAgua = distancia * alturaPueblo - (totalAgua + alturaPueblo);
//            System.out.println(totalAgua);
//            distancia = leer.nextInt();
//            salir = distancia == 0;
//        }
//        leer.close();
//    }

//    public static void main(String[] args) {
//        Scanner leer = new Scanner(System.in);
//        int distancia;
//        while ((distancia = leer.nextInt()) != 0) {
//            int totalAgua = 0;
//            for (int i = 0; i < distancia - 1; i++) {
//                totalAgua += leer.nextInt();
//            }
//            int alturaPueblo = leer.nextInt();
//            totalAgua = distancia * alturaPueblo - (totalAgua + alturaPueblo);
//            System.out.println(totalAgua);
//        }
//    }

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bfr = new BufferedReader(isr);
        int distancia;
        int totalAgua = 0;
        int i = 0;
        int alturaPueblo = 0;
        int valor;
        while ((distancia = Integer.parseInt(bfr.readLine())) != 0) {
            String[] values = bfr.readLine().split(" ");
            for (String paso : values) {
                valor = Integer.parseInt(paso);
                totalAgua += valor;
                if (i++ == distancia - 1) {
                    alturaPueblo = valor;
                    break;
                }
            }

            totalAgua = distancia * alturaPueblo - (totalAgua);
            System.out.println(totalAgua);
            i = 0; totalAgua = 0;
        }

        }
}
