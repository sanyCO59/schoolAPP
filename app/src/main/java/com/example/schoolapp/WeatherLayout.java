package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import kotlin.Suppress;

public class WeatherLayout extends AppCompatActivity {
    TextView temp, wind;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_layout);
        temp = findViewById(R.id.textView4);
        wind = findViewById(R.id.textView3);

    }

    public void move1(View view) {
        String url = "https://api.weatherapi.com/v1/current.json?key=0ee91ede48064c6ca10163401231401&q=Борисоглебск&aqi=no";
        new GetURLData().execute(url);
    }
    public class GetURLData extends AsyncTask<String, String, String> {
        protected void onPreExecute() {
            super.onPreExecute();
            temp.setText("ожидайте...");
            wind.setText("ожидайте...");
        }

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line).append("\n");
                    return buffer.toString();
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (connection != null) connection.disconnect();
                try {
                    if (reader != null) reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(String result) {
            try {
                JSONObject jsonObject = new JSONObject(result);
                temp.setText("Температура: " + jsonObject.getJSONObject("current").getDouble("temp_c"));
                wind.setText("Ветер: " + jsonObject.getJSONObject("current").getDouble("wind_kph") + "км/ч");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
