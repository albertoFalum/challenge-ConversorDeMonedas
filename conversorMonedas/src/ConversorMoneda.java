import com.google.gson.Gson;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConversorMoneda {
    private final String key = "b64132615da554529eac9f75";

    public double convertir(CodigoMoneda from, CodigoMoneda to, double valor){
        String convertirDe = from.name();
        String covertirA = to.name();
        double resultado;

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + key + "/latest/" + convertirDe);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            ExchangeRateApiResponse apiResponse = gson.fromJson(response.body(), ExchangeRateApiResponse.class);

            Map<String, Double> conversionRates = apiResponse.conversion_rates();
            double conversionRate = conversionRates.get(covertirA);
            resultado = conversionRate * valor;
            return Math.round(resultado * 100.0) / 100.0;

        } catch(ConnectException e){
            System.out.println("Error: No se pudo conectar a la API de tasas de cambio.");
            return -1;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
