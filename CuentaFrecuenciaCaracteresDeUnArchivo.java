

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class CuentaFrecuenciaCaracteresDeUnArchivo {
    public static void main(String[] args) throws IOException {


        try(FileInputStream fis = new FileInputStream(args[0])){
            char array [] = new char[fis.available()];
            int k =0;
            while (fis.available()>0){
                array[k] = (char) fis.read();
                k++;
            }
            Arrays.sort(array);

            for (int i = 0; i < array.length; i++) {
                if (i == 0 || array[i] != array[i - 1]) {
                    int contador = 0;

                    // Contar cuántas veces aparece el carácter
                    for (int j = 0; j < array.length; j++) {
                        if (array[i] == array[j]) {
                            contador++;
                        }
                    }

                    // Imprimir el carácter y su contador
                    System.out.println(array[i] + " " + contador);
                }

            }
        }
    }
}
