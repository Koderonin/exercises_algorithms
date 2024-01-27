import java.io.*;
import java.util.*;

public class Votacion2 {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Vinlex\\Escritorio\\tests_votación.txt");
        Scanner sc = new Scanner(file);
        BufferedReader bfr = new BufferedReader(new FileReader(file));
        ArrayList<String> resultados = new ArrayList<>();
        //hacemos un bucle que lea de la entrada el número de votos emitidos y los guarde en la variable "votosEmitidos"
        //una vez leido el 0, terminamos el bucle
        int votosEmitidos = 0;
        while ( (votosEmitidos = Integer.parseInt(bfr.readLine())) != 0) {
            // Creamos un mapa para almacenar los votos por cada candidatura
            Map<String, Integer> votosPorCandidatura = new HashMap<>();
            // ahora leemos los votos. Vienen en distintas lineas
            while (votosEmitidos > 0) {
                //leemos los votos de la linea y los guardamos en la variable "votosLinea"
                String[] votosLinea = bfr.readLine().split(" ");
                //restamos la cantidad de votos a votosEmitidos
                votosEmitidos -= votosLinea.length;
                // Recorremos la variable "votosLinea" y contamos los votos por cada candidatura
                for (String candidatura : votosLinea) {
                    if (votosPorCandidatura.containsKey(candidatura)) {
                        votosPorCandidatura.put(candidatura, votosPorCandidatura.get(candidatura) + 1);
                    } else {
                        votosPorCandidatura.put(candidatura, 1);
                    }
                } // fin del bucle for
            } // fin del bucle while
            // ahora tengo que ordenar el mapa de mayor a menor
            List<Integer> sortedVotos = new ArrayList<>(votosPorCandidatura.values());
            Collections.sort(sortedVotos, Collections.reverseOrder());
            if (votosPorCandidatura.size() > 1 && sortedVotos.get(0) == sortedVotos.get(1)) {
                //resultados.add("EMPATE");
                System.out.println("EMPATE");
            } else if (votosPorCandidatura.size() == 1) {
                //resultados.add((String) votosPorCandidatura.keySet().toArray()[0]);
                System.out.println((String) votosPorCandidatura.keySet().toArray()[0]);
            } else {

                System.out.println(buscaGanador(votosPorCandidatura));
            }
        }
    }

    private static String buscaGanador(Map<String, Integer> votosPorCandidatura) {
        Integer max = 0;
        String candidaturaElegida = "";
        for (Map.Entry<String, Integer> candidatura : votosPorCandidatura.entrySet()) {
            if (candidatura.getValue() > max) {
                max = candidatura.getValue();
                candidaturaElegida = candidatura.getKey();
            }
        }
        return candidaturaElegida;
    }
}
