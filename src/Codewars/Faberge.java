package Codewars;

import java.math.BigInteger;

/*
* Un huevo se rompe a partir de cierta altura, que siempre es la misma. Por debajo de esa altura, el huevo no se rompe.
* Dados dos enteros positivos n y m, siendo n el número de huevos y m el número de intentos,
* devolver la altura máxima de un edificio tal que garantice encontrar la altura a la que el huevo no se rompe.
*/
public class Faberge {
    public static BigInteger height(BigInteger eggs, BigInteger tries) {
        if (eggs.equals(BigInteger.ZERO) || tries.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }

        return eggs.subtract(tries); // TODO replace with your solution
    }
}
