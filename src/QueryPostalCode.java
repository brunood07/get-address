import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QueryPostalCode {
    public Address queryByPostalCode(String postalCode) {
        String formattedPostalCode = postalCode.replace("-", "");
        URI endpoint = URI.create("https://viacep.com.br/ws/" + formattedPostalCode + "/json/");

        HttpRequest request = HttpRequest.newBuilder().uri(endpoint).build();

        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o endereço a partir do CEP informado");
        }

        return new Gson().fromJson(response.body(), Address.class);
    }
}
