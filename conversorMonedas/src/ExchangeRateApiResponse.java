import java.util.Map;

public record ExchangeRateApiResponse(
        String result,
        String base_code,
        String target_code,
        Map<String, Double> conversion_rates) {

}
