import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public ConversionApi convierteMoneda(String monedaBase,String monedaDestino, double monto){
        String apikey = "tu-apikey-real";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apikey+"/pair/"+monedaBase+"/"+monedaDestino+"/"+monto);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),ConversionApi.class);
        } catch (Exception e) {
            throw new RuntimeException("No pudé hacer esa conversión (ToT)");
        }
    }
}
