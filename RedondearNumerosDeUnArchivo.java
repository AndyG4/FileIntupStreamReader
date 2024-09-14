
import java.io.*;
import java.util.*;

public class RedondearNumerosDeUnArchivo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String path1 = br.readLine();
        String path2 = br.readLine();

        try(BufferedReader reader = new BufferedReader(new FileReader(path1));
            PrintWriter pw = new PrintWriter(new FileWriter(path2))
        ) {

            while (reader.ready()){
                String linea [] = reader.readLine().split(" ");
                for(String lien : linea){
                    double valor = Double.parseDouble(lien);
                    long redondear = Math.round(valor);
                    pw.print(redondear+" ");
                }
            }
        }

    }
}
