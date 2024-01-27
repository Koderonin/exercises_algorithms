import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Votacion {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String paisVotado = "";
        int totalVotos = 0;
        while ((totalVotos = Integer.parseInt(bfr.readLine())) != 0) {
            Map<String,Integer> votos = new HashMap<>();
            while (totalVotos > 0) {
                String[] votosLinea = bfr.readLine().split(" ");
                totalVotos -= votosLinea.length;
                for (String pais : votosLinea) {
                    if (votos.containsKey(pais)) {
                        votos.put(pais, votos.get(pais) + 1);
                    } else {
                        votos.put(pais, 1);
                    }
                }
            }
            List<Integer> votosPais = new ArrayList<>(votos.values());
            Collections.sort(votosPais, Collections.reverseOrder());

            if (votosPais.size() > 1 && Objects.equals(votosPais.get(0), votosPais.get(1))) {
                System.out.println("EMPATE");
            } else if (votosPais.size() == 1) {
                System.out.println(votos.keySet().toArray()[0]);
            } else {
                System.out.println(buscaGanador(votos));
            }
        }
    }

    private static String buscaGanador(Map<String, Integer> votos) {
        Integer max = 0;
        String paisElegido = "";
        for (Map.Entry<String, Integer> paises : votos.entrySet()) {
            if (paises.getValue() > max) {
                max = paises.getValue();
                paisElegido = paises.getKey();
            }
        }
        return paisElegido;
    }
}