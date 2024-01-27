package Codewars;

public class RainTacos {

    public static void main(String[] args) {
        String prueba = "       \n       \n   *   \n  *** *\n ***** ";
        String prueb2 = "--- ---   ----\n--------------";
        System.out.println(rainTacos(prueba));
        System.out.println(rainTacos(prueb2));
    }

    public static String rainTacos(String landscape) {
        if (landscape.isEmpty()) {
            return "";
        }
        int width = landscape.indexOf("\n");
        String[] landscapeLayers = landscape.split("\n");
        int height = landscapeLayers.length;
        char[][] result = new char[width][height];
        int i = 0;

        for (int j = 0; j < height; j++) {
            for (int k = 0; k < width; k++) {
                result[k][j] = landscapeLayers[j].charAt(k);
            }
        }

        for (int j = 0; j < width; j++) {
            for (int k = 0; k < height; k++) {
                if(result[j][k] != ' '){
                    if (k == 0){
                        break; // ya no hay que mirar más en la columna
                    } else {
                        result[j][k-1] = returnLetter(j);
                        break; // se coloca la letra y paso a la siguiente columna
                    }
                }
                if (k == height - 1) {
                    result[j][k] = returnLetter(j);
                }
            }
        }

        for (int j = 0; j < height; j++) {
            for (int k = 0; k < width; k++) {
                System.out.print(result[k][j]);
            }
            System.out.println();
        }

        StringBuilder strReturn = new StringBuilder();
        for (int j = 0; j < height; j++) {
            for (int k = 0; k < width; k++) {
                strReturn.append(result[k][j]);
            }
            if (j != height - 1)
                strReturn.append("\n");
        }
        return strReturn.toString();
    }

    private static char returnLetter(int column) {
        if (column % 4 == 0) {
            return 'T';
        }
        if (column % 4 == 1) {
            return 'A';
        }
        if (column % 4 == 2) {
            return 'C';
        }
        if (column % 4 == 3) {
            return 'O';
        }
        return ' ';
    }
}
/*
* public class RainTacos {
  public static final char[] TACO = new char[]{'T', 'A', 'C', 'O'};
  public static String rainTacos(String landscape) {
    String[] ar = landscape.split("\n");
    char[][] arr = new char[ar.length][];
    for(int i = 0 ; i < arr.length ; i ++)
      arr[i] = ar[i].toCharArray();
    for(int i = 0 ; i < arr[0].length ; i++) {
      int j = 0 ;
      while(j != arr.length && arr[j][i] == ' ') {
        j++;
      }
      if(j > 0)
        arr[j - 1][i] = TACO[i % TACO.length];
    }
    for(int i = 0 ; i < arr.length ; i ++)
      ar[i] = new String(arr[i]);
    return String.join("\n", ar) ;
  }
}
* */