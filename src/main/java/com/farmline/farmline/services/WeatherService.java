package com.farmline.farmline.services;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class WeatherService {
    private static final String API_KEY = "your_api_key";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=Accra&appid=" + API_KEY;

    public String getWeatherData() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            }

            StringBuilder weatherData = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                weatherData.append(scanner.nextLine());
            }
            scanner.close();

            JSONObject json = new JSONObject(weatherData.toString());
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}