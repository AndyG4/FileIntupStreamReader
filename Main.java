
import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try(Scanner sc = new Scanner(System.in);
        FileInputStream fis = new FileInputStream(sc.nextLine())){
            int valor_assci = (int)((char)(','));
            int contador =0;
            while (fis.available() > 0){
                int valor = fis.read();
                if(valor==valor_assci){
                    contador++;
                }
            }
            System.out.println(contador);
        }

    }
}
