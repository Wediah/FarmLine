package com.farmline.farmline.services;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {
    private static final String API_KEY = ""; // Replace with your API key
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=Accra&appid=" + API_KEY;

    public String getFormattedWeatherData() {
        try {
            // Fetch the JSON response from the API
            String jsonResponse = getWeatherData();

            // Parse the JSON response
            JSONObject jsonObject = new JSONObject(jsonResponse);

            // Extract relevant fields
            String city = jsonObject.getString("name");
            JSONObject main = jsonObject.getJSONObject("main");
            double temperatureKelvin = main.getDouble("temp"); // Temperature in Kelvin
            int humidity = main.getInt("humidity");            // Humidity in percentage
            JSONObject weather = jsonObject.getJSONArray("weather").getJSONObject(0);
            String description = weather.getString("description"); // Weather description

            // Convert temperature from Kelvin to Celsius
            double temperatureCelsius = temperatureKelvin - 273.15;

            // Format the weather data
            return String.format("City: %s\nTemperature: %.2f°C\nHumidity: %d%%\nDescription: %s",
                    city, temperatureCelsius, humidity, description);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to fetch or parse weather data.";
        }
    }

    private String getWeatherData() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to fetch weather data.";
        }
    }
}
