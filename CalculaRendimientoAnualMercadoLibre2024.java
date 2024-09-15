import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class CalculaRendimientoAnualMercadoLibre2024 {
    public static void main(String[] args) throws Exception {
        String path = "";//aqui ingresas la direccion del disco donde deseas guardar el documento por ejemplo, c:\documentos\salida.txt (puede ser txt, csv, xml etc..).
        double rend1 = 0.012; //rednimiento anual de mercado libre  durante enero-marzo
        double rend2 = 0.015;//rednimiento anual de mercado libre  durante abril-diciembre
        double Saldo = 0;//tu saldo inicial en la cuenta.
        int incremento = 1600; //la cantidad de dinero que ingresaras de forma constante cada mes
        double rendimiento=0.0;

        String guion []  = new String[60];
        String g = "";

        for(int i = 0; i<guion.length;i++){
            guion[i]="_";
        }
        for(String i : guion){
            g+=i;
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        try(PrintWriter pw = new PrintWriter(new FileWriter(path))){
            pw.print("                 Impreso y escrito con amor.");
            pw.println();
            for (int i = 1; i <= 12; i++) {
                 rendimiento = Saldo*rend1 + incremento;
                if(i>4){ // apartir del mes 4 el ingreso en la cuenta cambia
                    incremento=2000;
                 rendimiento = Saldo*rend2 + incremento;
                }

                Saldo+=rendimiento;
                if(i==12){
                    Saldo+=2000; //en diciembre cae el aguinaldo y lo agregamos a nuestro fondo de ahorro.
                }
                pw.println(g);
                pw.println(String.format("    saldo :| mes: %-2d : $%-10s | ganancias: $%-10s", 
                            i, decimalFormat.format(Saldo), decimalFormat.format(rendimiento - incremento)));
                pw.println(g);
            }

        }
    }
}
