

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RevertirArchivo {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream entrada = new FileInputStream(br.readLine());
            FileOutputStream salida = new FileOutputStream(br.readLine())){

            List<Integer> lista = new ArrayList<>();
            while (entrada.available()>0){
                lista.add(entrada.read());
            }
            Collections.reverse(lista);
            
            for (Integer i : lista){
                salida.write(i);
            }
        }

    }
}
