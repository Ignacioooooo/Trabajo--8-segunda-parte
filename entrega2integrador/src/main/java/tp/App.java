package tp;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/*INTEGRANTES TP INTEGRADOR:
Balda Lautaro
Sosa Ignacio
Suarez Facundo
Velasquez Rivera Brian
 */
public class App {
    public static void main(String[] args) throws Exception{

        String pronosticos = ".\\pronosticos.csv";
        String resultados = ".\\resultados.csv"; 

        //llamada al método que compara dos archivos para evaluar si el pronóstico fue acertado o no.
        App.CompararResultado(pronosticos,resultados);
    }


    public static void CompararResultado(String Pronostico, String Resultado) throws IOException {
        
        // Primero archivo CSV
        BufferedReader reader1 = new BufferedReader(new FileReader(Pronostico));

        Map<String, String> resultados1 = new HashMap<>();

        String linea;
        while ((linea = reader1.readLine()) != null) {

            String[] valores = linea.split(";");

            String nombre = valores[0];

            StringBuilder datos = new StringBuilder();
            for (int i = 1; i < valores.length; i += 2) {
                String equipo = valores[i];
                String goles = valores[i + 1];
                datos.append(equipo).append(": ").append(goles).append(", ");
            }

            resultados1.put(nombre, datos.toString());
        }

        reader1.close();

        // Segundo archivo CSV
        BufferedReader reader2 = new BufferedReader(new FileReader(Resultado));

        Map<Integer, String> resultados2 = new HashMap<>();

        int ronda = 0;
        while ((linea = reader2.readLine()) != null) {

            String[] valores = linea.split(";");

            ronda = Integer.parseInt(valores[0]);

            StringBuilder datos = new StringBuilder();
            for (int i = 1; i < valores.length; i += 2) {
                String equipo = valores[i];
                String goles = valores[i + 1];
                datos.append(equipo).append(": ").append(goles).append(", ");
            }

            resultados2.put(ronda, datos.toString());
        }

        reader2.close();

        // Imprime los mapas resultantes
        System.out.println("Archivo 1:");
        for (String nombre : resultados1.keySet()) {
            String datos = resultados1.get(nombre);
            System.out.println(nombre + " - " + datos);
        }

        System.out.println("Archivo 2:");
        for (Integer numRonda : resultados2.keySet()) {
            String datos = resultados2.get(numRonda);
            System.out.println("Ronda " + numRonda + " - " + datos);
        }
    }

}

    
