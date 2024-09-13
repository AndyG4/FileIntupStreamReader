
import java.io.*;

public class ConcatenaDosArchivosEnUno {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String path = br.readLine();
        try(FileInputStream fis = new FileInputStream(path);
            FileInputStream f1 = new FileInputStream(br.readLine());
            FileOutputStream f2 = new FileOutputStream(br.readLine())){

            byte [] cadena1 = new byte[fis.available()];
            byte [] cadena2 = new byte[f1.available()];
            fis.read(cadena1);
            f1.read(cadena2);

            f2.write(cadena1);
            f2.write(cadena2);
        }
    }
}
