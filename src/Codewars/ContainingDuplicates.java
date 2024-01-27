package Codewars;

import java.util.*;

public class ContainingDuplicates {

    public static void main(String ...args){
        String testThousandA = new String(new char[1000]).replace('\0', 'a');
        String testHundredB = new String(new char[100]).replace('\0', 'b');
        String testTenC = new String(new char[10]).replace('\0', 'c');
        String test1CapitalA = new String(new char[1]).replace('\0', 'A');
        String test1d = new String(new char[1]).replace('\0', 'd');
        String test = test1d + test1CapitalA + testTenC +
                testHundredB + testThousandA;
        System.out.println(duplicateCount2("abcde"));
        System.out.println(duplicateCount2("aabbcde"));
        System.out.println(duplicateCount2("indivisibility"));
        System.out.println(duplicateCount2("Aa11"));
        System.out.println(duplicateCount2(test));
        System.out.println("aaaaaaaaaaa"+"bbbbbbbbb"+"ccccccccc"+"A");
    }

    public static int duplicateCount(String text) {
        if (text.isEmpty()){
            return 0;
        }
        Map<Character,Integer> charMap = new LinkedHashMap<>();
        char[] charArray = text.toCharArray();
        char letra;
        for (int i = 0 ; i < charArray.length ; i++) {
            letra = Character.toLowerCase(charArray[i]);
            if (charMap.containsKey(letra)){
                charMap.put(letra, charMap.get(letra) + 1);
            } else {
                charMap.put(letra, 1);
            }
        }
        List<Integer> ocurrencias = new ArrayList<>(charMap.values());
        ocurrencias.sort(Collections.reverseOrder());

        int contador = 0, i = 0 ;
        if (ocurrencias.get(0)>1){
            do {
                contador++;
                i++;
            }
            while(i < ocurrencias.size() && ocurrencias.get(i) != 1);
        }
        return contador;
    }

    public static int duplicateCount2(String text) {
        int ans = 0;
        text = text.toLowerCase();
        while (text.length() > 0) {
            String firstLetter = text.substring(0,1);
            text = text.substring(1);
            if (text.contains(firstLetter)) ans ++;
            text = text.replace(firstLetter, "");
        }
        return ans;
    }

}
