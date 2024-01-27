package Codewars;

import java.util.*;

/* Kata Position by order (https://www.codewars.com/kata/62c300bd4ca9447eb32b3ffd/):
* Given a list of size "n" of any type of comparable elements and an order "m" in [1..n] inclusive, determine in which position is stored the element that would occupy the m-th position if the list were ordered .
It is ensured that m < n.
*
* It must be ensured that for a list of 10^6 elements, the execution time is less than 500ms.

Duplicate items are not allowed

Note that the order starts at position 1 but the list starts at 0.

Example

    [2,1,5,6,3,4], 3

-> sol is 4 because in order ([1,2,|3|,4,5,6]) the 3rd elements is a "3", that is in position 4 in the original one.

    ["j","a","h", "l"], 1

-> sol is 1 because the order of the original list is ([|"a"|, "h","j","l"]), "a" is in the first position, that is in position 1 in te original one.
* */
public class OrderedPosition {

    public static void main(String[] args) {
        System.out.println(orderedPositionOf(new String[] {"first", "second", "third", "fourth"}, 3));
        System.out.println(orderedPositionOf(new String[] {"Madrid", "Lisbon", "Paris", "London","Rome"}, 4));
        System.out.println(orderedPositionOf(new Integer[]{1, 2,3,4,5},4));
        System.out.println(orderedPositionOf(new Integer[]{1, 2,3,4,5},1));
    }

    //David dice algo sobre PriorityQueue, vamos a ver cómo funciona (prueba 1; creo un PQ, saco el elemento que quiero, luego busco en array)
    //Implementation note: this implementation provides O(log(n)) time for the enqueuing and dequeuing methods (offer, poll, remove() and add);
    //linear time for the remove(Object) and contains(Object) methods; and constant time for the retrieval methods (peek, element, and size).
    public static <E extends Comparable<E>> int orderedPositionOf(E[] data, int order) {
        // Creo un PriorityQueue porque lo dice David. Leyendo la documentación de la clase, tiene sentido.
        PriorityQueue<E> priorityQueue = new PriorityQueue<>();
        // Hay que añadir los elementos del array a la PriorityQueue pa poder trabajar con ello (esto "ordena" los elementos).
        // Algo así como una lista ordenada (o un set, en este caso, no se permiten elementos duplicados).
        priorityQueue.addAll(Arrays.asList(data));
        // hay que recorrer el pq hasta el elemento que vamos a coger.
        for (int i = 1; i < order; i++) {
            priorityQueue.remove();
        }
        // el siguiente elemento es el que queremos.
        E eObjetivo = priorityQueue.peek();
        // y lo busco en el array, devolviendo su posición.
        int i = 0;
        for(E e : data) {
            if(e.equals(eObjetivo)) {
                return i;
            }
            i++;
        }
        return 0;
    }
    /* Mi solución lenta (>500ms)
    public static <E extends Comparable<E>> int orderedPositionOf(E[] data, int order) {
        E[] dataAux = Arrays.copyOf(data, data.length);
        Collections.sort(Arrays.asList(dataAux));
        Object objetoBuscado = dataAux[order-1];
        for(int i = 0; i < data.length ; i++) {
            if(data[i] == objetoBuscado) {
                return i;
            }
        }

        return 0;
    }
    */
}
