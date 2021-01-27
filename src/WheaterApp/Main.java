package WheaterApp;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

public class Main {

    private static final String url = " https://api.openweathermap.org/data/2.5/weather";
    private static final String key = ""; // Need to supply APIKey.
    private static final String urlForecast = "https://api.openweathermap.org/data/2.5/forecast";
    private static final String units = "imperial";
    private static final String charset = StandardCharsets.UTF_8.name();

    //public static void main(String[] args) {
    public static WeatherConditions getWeatherConditions (String city){
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter City: ");

        //String city = scanner.next();

        try{
            String query = String.format("?q=%s&apiKey=%s",
                    URLEncoder.encode(city, charset),
                    URLEncoder.encode(key, charset));

            // Create the connection:
            URLConnection connection;
            connection = new URL(url + query).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            InputStream response = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(response));

            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            //  Deserialize
            Gson gson = new Gson();
            WeatherConditions conditions = gson.fromJson(stringBuilder.toString(), WeatherConditions.class);
            System.out.println(stringBuilder.toString());
        }
        catch (UnsupportedEncodingException ex){}
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
