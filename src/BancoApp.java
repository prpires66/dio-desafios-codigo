import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class BancoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double valorInicial = scanner.nextDouble();
        double taxaJuros = scanner.nextDouble();
        int periodo = scanner.nextInt();
        double valorFinal = valorInicial;

        double taxaJurosAcumulada = 1;
        DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(new Locale("pt_BR")));
        df.applyPattern("0.00");
        for (int i = 0; i < periodo; i++) {
            taxaJurosAcumulada *= (1 + taxaJuros);
        }
        valorFinal = valorInicial * taxaJurosAcumulada;

        System.out.println("Valor final do investimento: R$ " + df.format(valorFinal));

        scanner.close();
    }
}