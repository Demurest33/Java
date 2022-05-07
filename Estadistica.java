/**
 *
 * @author Javier Jara Renteria
 */

public class Estadistica {
    //Rango de numeros aleatorios y el array
    private int max = 10, min = 1;
    int index=0;
    
    //Arreglo int
    int[] arreglo = new int[max];

    public static void main(String[] args) {
        
        Estadistica nimi = new Estadistica();
        
        System.out.println("La moda del arreglo es: " + nimi.moda());
        System.out.println("La media del arreglo es: " + nimi.media());
        nimi.ordena();
        nimi.imprime();
        System.out.println("El percentil de 2 es: " + nimi.percentil(2));
        nimi.encuentra(2);
        System.out.println("El rango es del arreglo es igual a: " + nimi.rango());
        System.out.println("La desviacion estandar es: " + nimi.desviacionEstandar());

    }
    
    Estadistica(){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random()*(max)) + min;
        }
    }
    
    public int moda(){
        int num,rep=0,moda=0,modarep=0;
        
        for (int i = 0; i < arreglo.length; i++) {
            rep=0;
            num = arreglo[i];
            
            for (int j = 0; j < arreglo.length; j++) {
                if(num == arreglo[j]){
                    rep++;
                }
            }
            
            if(rep>=modarep){
                moda = num;
                modarep = rep;
            }
        }
        
        return moda;
    }
    //El ejemplo del pdf pone el resultado en decimales pero al instriccion dice int
    public double media(){
        double total=0;
        for (int i = 0; i < arreglo.length; i++) {
            total +=arreglo[i];
        }
        return (total/arreglo.length); //El pfd dice que sea int //El java redondea todo el numero para abajo
    }
    
    public void ordena(){
        int[] nuevo = new int[max];
        for (int i = 0; i < nuevo.length; i++) {
            if(menor()!=777){
                nuevo[i] = menor();
            }else{
                continue;
            }
            //index es la posicion en donde se encontró el número menor
            arreglo[index] = 777;
        }
        
        System.out.println("El Arreglo ordenado: ");
        for (int i = 0; i < nuevo.length; i++) {
            arreglo[i] = nuevo[i];
            System.out.println(arreglo[i]);
        }
    }
    
    public int menor(){
        int menor=max+1;
        
        //Encontrar el numero menor
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i]<menor){
                //System.out.println(arreglo[i] + "<" + menor);
                menor=arreglo[i]; 
            }    
        }
        //Encontrar el index del menor para poder remplazar su valor con 777
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] == menor){
                index=i;
            }
        }
        
        //System.out.println("El numero menor es: " + menor);
        return menor;
    }
    
    public int mayor(){
        int mayor=min-1;
        
        //Encontrar el numero menor
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i]>mayor){
                //System.out.println(arreglo[i] + ">" + mayor);
                mayor=arreglo[i];
            }    
        }
        //System.out.println("El numero mayor es: " + mayor);
        return mayor;
    }
    
    public void imprime(){
        System.out.println("****Imprimiendo el arreglo****");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }
    }
    
    public int percentil(int numero){ 
        //Regresa cuantos elementos fueron mayores o iguales a número
        int percentil =0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] >= numero){
                percentil++;
            }
        }
        
        return percentil;
    }
    
    public void encuentra(int numero){ 
        //Indica las posiciones en el arreglo donde se encuentra dicho número
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] == numero){
                System.out.println(numero + " Se encuentra en la posicion " + i);
                index=i;
            }
        }
    }
    
    public int rango(){
        return (mayor()-menor());
    }
    
    //El ejemplo del pdf pone el resultado en decimales pero al instriccion dice int
    public double desviacionEstandar(){
        
        double media = media(), total=0,desv=0;
        //System.out.println("La media es: " + media);
        
        for (int i = 0; i < arreglo.length; i++) {
            total += Math.pow((arreglo[i]-media),2);
        }
        //System.out.println("El total es: " +total);
        
        desv = Math.sqrt(total/(max-1));
        
        //System.out.println("La desviacion estandar es: " + desv);
        return desv;
    }
}