/**
 * @author Javier Jara Renteria
 */
import java.util.Scanner;
    
public class PPT {
    
    Scanner input = new Scanner(System.in);
    String nombre;
    int rondas,victorias,derrotas,empates;
    int rondasArreglos = 21;
    
    public static void main(String[] args) {
        //Objetos
        Scanner input = new Scanner(System.in);
        PPT laffey = new PPT();
        
        String ganador;
        
        //Leer jugador
        System.out.println("Ingrese su nombre: ");
        laffey.nombre = input.nextLine();
        System.out.println("Cuantas rondas tendra la partida?: ");
        laffey.rondas = input.nextInt();
        
        //Iniciar partida
        ganador = laffey.partida();
        
        //Imprimir quien ganó la partida
        System.out.println(ganador);
    }
    
    
    public int leerjuagada(){
        int jugada;
        System.out.println("Haga su jugada: ");
        jugada = input.nextInt();
        
        return jugada;
    }
    
    public int maquina(){
        int aleatorio = 0;
        //Trabaja con valores de tipó double entonces hacemos el casting a int
        //El tres es el rango maximo al que vamos a generar numeros aleatorios //0,1,2
        aleatorio = (int) (Math.random()*3);
        return aleatorio;
    }
    
    public String partida(){
        int eleccion, maquina;
        String ganador="";
        //Lista de movimientos
        String[] jugadas = {"Piedra","Papel","Tijeras"};

        //Usar un arreglos para guardar los resultados 
        String[] resultados = new String[rondas];
        int[] movimientosJugador = new int[rondas];
        int[] movimientosMaquina = new int[rondas];
        
        //Reglas
        System.out.println("La partida se decidira a " + rondas);
        System.out.println("0=Piedra 1=Papel 2=Tijera");
        System.out.println("En caso no usar una de las opciones anteriores su movimiento sera decido aleatoriamente");
        
        //Ciclo de la partida        
        for (int i = 0, con = 1; i < rondas; i++) {
            
            System.out.println("Ronda no."+con);
            eleccion = leerjuagada();
            if (eleccion > 2 || eleccion < 0){
                System.out.println("Su eleccion se sale del rango, la respuesta sera decidida de manera aleatoria");
                eleccion = maquina();
            }
            
            maquina = maquina();
            
            //guardamos movimientos en un arreglo
            movimientosJugador[i] = eleccion;
            movimientosMaquina[i] = maquina;
            
            //Imprimir el ganador
            //0-->2 || 1-->0 || 2-->1
            if (eleccion == maquina){
                empates++;
                System.out.println(jugadas[eleccion] + " contra " + jugadas[maquina] +" la ronda es un empate");
                resultados[i] = "Empate";
            }else if (eleccion == 0 && maquina == 2){
                victorias++;
                System.out.println(jugadas[eleccion] + " contra " + jugadas[maquina] + " " + nombre + " gana esta ronda");
                resultados[i] = "Jugador";
            }else if (eleccion == 1 && maquina == 0){
                victorias++;
                System.out.println(jugadas[eleccion] + " contra " + jugadas[maquina] + " " + nombre + " gana esta ronda");
                resultados[i] = "Jugador";
            }else if (eleccion == 2 && maquina == 1){
                victorias++;
                System.out.println(jugadas[eleccion] + " contra " + jugadas[maquina] + " " + nombre + " gana esta ronda");
                resultados[i] = "Jugador";
            }else{
                derrotas++;
                System.out.println(jugadas[eleccion] + " contra " + jugadas[maquina] + " " + nombre + " pierde esta ronda");
                resultados[i] = "Compu";
            }
            
            //Terminando las jugadas mostrar el marcador
            System.out.println("--------------------");
            System.out.println("Computadora: " + derrotas);
            System.out.println(nombre + ": " + victorias);
            System.out.println("Empate: " + empates);
            System.out.println("--------------------");
            
            con++;
        }
        
        //Imprimir resultados y movimientos de todas las rondas en una tabla
        System.out.println("       ***Resultados finales***");
        
        
        for (int i = 0; i < movimientosJugador.length; i++) {
            System.out.println("/Computadora/    /Jugador/    /Resultado/");
            System.out.println("   " + jugadas[movimientosMaquina[i]] + "          " + jugadas[movimientosJugador[i]] + "       " + resultados[i]);
        }
        
        //Buscar al ganador
        if (empates > victorias && empates > derrotas){
            //System.out.println("   ---La partida terminó en empate---");
            ganador = "   ---La partida terminó en empate---";
        }else if(victorias > derrotas && victorias >= empates){
            //System.out.println("   ---Ganó " + nombre +"---");
            ganador = "          ---Ganó " + nombre +"---";
        }else{
            //System.out.println("   ---Esta vez gana la computadora---");
            ganador = "          ---Ganó la Compu---";
        }
        
        //retornar el resultado del ganador
        return ganador;
    }
}