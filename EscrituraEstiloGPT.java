import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class EscrituraEstiloGPT {
    public static void main(String[] args) throws InterruptedException  {
        System.out.println("Hello, World!");

        try {
            
            InputStreamReader isr  = new InputStreamReader(new FileInputStream("C:\\Users\\elmic\\OneDrive\\Escritorio\\TDA II TAREAS\\pulpos.txt"), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String cadena = "";

            String linea="";
            while ((linea = br.readLine())!=null) {
                cadena+=linea;
            }
            br.close();
            char array [] = cadena.toCharArray();

            for(int i = 0; i<array.length; i++){
                double random =(double)( Math.random()*38);
                System.out.print(array[i]);
                tiempo(random);
            }
            
        } catch (Exception e) {

        }
    }

    
    static void tiempo(double  valor){
        try {
            Thread.sleep((long) valor);
        } catch (Exception e) {
        }
    }
}
