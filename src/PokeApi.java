import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

    public static JSONObject moveAPI(String moveName) throws Exception {
        String urlString = BASE_URL + "move/" + moveName.toLowerCase();
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
//            GsonBuilder builder = new GsonBuilder();
//            builder.setPrettyPrinting();
//
//            Gson gson = builder.create();
//            Moves move = gson.fromJson(response.toString(), Moves.class);
//            return move;
        } else {
            System.err.println("Error: Received response code " + responseCode);
            return null;
        }
    }


}
