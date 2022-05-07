/**
 * Actividad Programacion Segundo Semestre
 *
 * @author Javier Jara Renteria
 */

import java.util.Scanner;

public class Gato {
    
    char matriz [][] = new char [3][3];
    int noJugadas=0;

    public static void main(String[] args) {
        
        Gato javelin = new Gato();
        Scanner input = new Scanner(System.in);
        
        char ganador='\0';

        System.out.println("Juego de #Gato");
        System.out.println("Ingrese su nombre: ");
        String nombre = input.nextLine();
        
        //Bucle de la wea
        
        while(ganador == '\0'){
            ganador = javelin.jugador();
            //System.out.println("Ganador del jugador: " + ganador);
            if(ganador == 'O' || ganador=='e'){break;}
            ganador = javelin.maquina();
            //System.out.println("Ganador de la maquina: " + ganador);
            if(ganador == 'X' || ganador=='e'){break;}
               
        }
        
        switch(ganador){
            case 'O':
                System.out.println("El ganador del encuentro es: " + nombre);
                break;
            case 'X':
                System.out.println("El ganador del encuentro es la maquina.");
                break;
            case 'e':
                System.out.println("El encuentro terminó en empate.");
                break;
        }
    }
    
    //Metodo constructor que imprima la figura del gato
    Gato(){
        int i = 1;
        
        for (int ren = 0; ren < matriz.length; ren++) {//El lenght siempre toma el valor de los renglones
            for (int colum = 0; colum < matriz[0].length; colum++) {//para tomar el length de las columnas
                //inicializamos todas las posiciones con valor nulo
                matriz[ren][colum] = '\0';
                
                //nadamas para tener algo que ver
                //matriz[ren][colum] = 'a';
                i++;
            }
        }
        imprime();
    }
    
    //Metodo donde imprimas los valores que lleva en ese momento el gato
    
    public void imprime(){
        for (int ren = 0; ren < matriz.length; ren++) {//El lenght siempre toma el valor de los renglones
            if (ren > 0 && ren <= 2){
                System.out.print("---------");
                System.out.print("\n");
            }
        
            for (int colum = 0; colum < matriz[0].length; colum++) { //para tomar el length de las columnas
                System.out.print(matriz[ren][colum]);
                if (colum >= 0 && colum < 2){
                    System.out.print(" | ");                    
                }
            }
            System.out.println("\n");
        }
    }
    
    //Metodo del tiro de la computadora que genero un número entre 1 y 3 para el renglo y columna
    
    public char maquina(){
        int a = (int) (Math.random()* (3));
        int b = (int) (Math.random()* (3));
        
        System.out.println("Tiro de la computadora: " + a +","+ b); 
        if(matriz[a][b] == '\0'){
            matriz[a][b] = 'X';
            imprime();
        }else{
            System.out.println("La casilla " + a + "," + b + " Se encuentra ocupada");
            imprime();
            maquina();
        }
        
        return ganador();
    }
    
    //Metodo para la tirada del jugador
    
    public char jugador(){
        
        Scanner input = new Scanner(System.in);
        int a,b;
        System.out.println("Indique los dos numeros de la coordenada de la tirada: (0,1,2)");
        a = input.nextInt();
        b = input.nextInt();
        
        if(matriz[a][b] == '\0'){
            matriz[a][b] = 'O';
            imprime();
        }else{
            System.out.println("La casilla " + a + "," + b + " Se encuentra ocupada");
            imprime();
            jugador();
        }
        noJugadas++;
        //System.out.println("Numero de jugadas realizadas por el jugador: " + noJugadas);
        return ganador();
    }
    
    //Metodo que valide al final de cada jugada si ya existe un ganador
    
    public char ganador(){
        
        char ganador='\0';
        if(matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2]){
            ganador = matriz[0][0];
        }else if(matriz[0][0] == matriz[0][1] && matriz[0][1] == matriz[0][2]){
            ganador = matriz[0][0];
        }else if(matriz[1][0] == matriz[1][1] && matriz[1][1] == matriz[1][2]){
            ganador = matriz[1][0];
        }else if(matriz[2][0] == matriz[2][1] && matriz[2][1] == matriz[2][2]){
            ganador = matriz[2][0];
        }else if(matriz[0][0] == matriz[1][0] && matriz[1][0] == matriz[2][0]){
            ganador = matriz[0][0];
        }else if(matriz[0][1] == matriz[1][1] && matriz[1][1] == matriz[2][1]){
            ganador = matriz[0][1];
        }else if(matriz[0][2] == matriz[1][2] && matriz[1][2] == matriz[2][2]){
            ganador = matriz[0][2];
        }else if(noJugadas == 5 && ganador == '\0'){
            ganador= 'e';
        }
        
        return ganador;
        
    }
}