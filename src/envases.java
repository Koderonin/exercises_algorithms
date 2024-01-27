import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.*;

public class envases {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int productos = leer.nextInt();
        for (int i = 0; i < productos; i++) {
            System.out.println(leer.nextInt() * -1 + leer.nextInt());
        }
    }
}