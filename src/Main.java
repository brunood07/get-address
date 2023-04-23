import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        QueryPostalCode query = new QueryPostalCode();

        System.out.println("Digite um CEP para consulta:");
        var postalCode = input.nextLine();

        try {
            Address newAddress = query.queryByPostalCode(postalCode);

            FileGenerator generate = new FileGenerator();
            generate.GenerateJson(newAddress);
            System.out.println(newAddress);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }
}