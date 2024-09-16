

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HilosYFiles {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Thread> threads = new ArrayList<>();
        String valor;

        // Leer los nombres de archivos y crear hilos
        while (!(valor = br.readLine()).equals("exit")) {
            ReadThread thread = new ReadThread(valor);
            threads.add(thread);
            thread.start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread thread : threads) {
            thread.join();
        }

        // Imprimir los resultados
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            System.out.println("Archivo: " + entry.getKey() + ", Byte más frecuente: " + entry.getValue());
        }
    }

    public static class ReadThread extends Thread {
        String archivo;

        public ReadThread(String fileName) {
            this.archivo = fileName;
        }

        @Override
        public void run() {
            byte[] frec = new byte[256];
            try (FileInputStream fis = new FileInputStream(archivo)) {
                while (fis.available() > 0) {
                    int valor = fis.read();
                    frec[valor]++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            int maxCont = 0;
            int byteMaxCon = 0;

            // Encontrar el byte con mayor frecuencia
            for (int i = 0; i < frec.length; i++) {
                if (frec[i] > maxCont) {
                    maxCont = frec[i];
                    byteMaxCon = i;
                }
            }

            // Almacenar el resultado en resultMap de manera sincronizada
            synchronized (resultMap) {
                resultMap.put(archivo, byteMaxCon);
            }
        }
    }
}
