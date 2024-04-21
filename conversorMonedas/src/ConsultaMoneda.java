import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ConsultaMoneda {

    private String key = "b64132615da554529eac9f75";
    private String convertirDe = "USD";
    private String covertirA = "EUR";
    private String monto = "2000";

    URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + key + "/pair/" + convertirDe + "/" + covertirA +"/" + monto);

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(direccion)
            .build();

}
