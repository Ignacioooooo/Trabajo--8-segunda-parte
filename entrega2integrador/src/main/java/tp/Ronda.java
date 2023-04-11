package tp;

import java.util.ArrayList;

public class Ronda {
    //Atributo con su respectivo get, para hipoteticamente solicitar el número de nuestra instancia de Ronda.
    private static int nroRonda = 0;
    
    //Otros atributos.
    ArrayList<Resultado> partidoResultado = new ArrayList<>();
    ArrayList<Pronostico> partidoPronostico = new ArrayList<>();



    int puntos = 0;

    public Ronda(Pronostico partidoPronostico1, Resultado partidoResultado1, Pronostico partidoPronostico2, Resultado partidoResultado2){
        this.partidoResultado.add(partidoResultado1);
        this.partidoResultado.add(partidoResultado2);

        this.partidoPronostico.add(partidoPronostico1);
        this.partidoPronostico.add(partidoPronostico2);


        this.partidoResultado.get(0).GanadorOEmpate();
        this.partidoResultado.get(1).GanadorOEmpate();
        this.partidoPronostico.get(0).GanadorOEmpate();
        this.partidoPronostico.get(1).GanadorOEmpate();
        nroRonda++;

    }

    public static int getNroRonda() {
        return nroRonda;
    }

    public int getPuntos() {
        return puntos;
    }


    public void ComprobarAcierto(){
        if(this.partidoResultado.get(0).equipoGanador.equals(this.partidoPronostico.get(0).equipoGanador) && 
        this.partidoResultado.get(1).equipoGanador.equals(this.partidoPronostico.get(1).equipoGanador)
        )
        {
            puntos++;
            System.out.println("¡Acertó los resultados de ambos partidos!\nSu puntaje es " + puntos);

        }else{
            System.out.println("No ha acertado uno o más partidos.\nSu puntaje es " + puntos);
        }
    }

}

