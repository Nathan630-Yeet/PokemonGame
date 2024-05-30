import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class PokeApi {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";

    public static JSONObject getPokemonData(String pokemonName) throws Exception {
        String urlString = BASE_URL + "pokemon/" + pokemonName.toLowerCase();
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        int responseCode = conn.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return new JSONObject(response.toString());
        } else {
            throw new Exception("Failed to fetch data from API");
        }
    }

    public static Moves moveAPI(String moveName) throws Exception {
        String urlString = BASE_URL + "move/" + moveName.toLowerCase();
        System.out.println("Requesting URL: " + urlString);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(urlString))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body();
            return parseMoveResponse(responseBody);
        } else {
            System.err.println("Error: Received response code " + response.statusCode());
        }

        return null;
    }

    private static Moves parseMoveResponse(String response) {
        return new Moves(response);
    }
}
