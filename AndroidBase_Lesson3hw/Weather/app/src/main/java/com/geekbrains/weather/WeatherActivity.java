package com.geekbrains.weather;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import es.dmoral.toasty.Toasty;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "WeatherActivity";
    private static final String TEXT = "TEXT";
    private static final String HUM = "HUM";
    private static final String WIND = "WIND";
    private static final String PRESS = "PRESS";
    private static final String CITY = "CITY";
    private TextView textView;
    private TextView textViewCity;
    private TextView tvHumidity;
    private TextView tvWind;
    private TextView tvPress;
    private FloatingActionButton fab;
    private Boolean isPressed = false;
    private static final DateFormat sdf = new SimpleDateFormat("k");
    Calendar cal;
    long time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_main);
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск";
        } else {
            instanceState = "Повторный запуск";
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Toasty.success(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();

        textView = findViewById(R.id.tv);
        textViewCity = findViewById(R.id.cityName);
        fab = findViewById(R.id.fab);

        tvHumidity = findViewById(R.id.tvHum);
        tvPress = findViewById(R.id.tvPress);
        tvWind = findViewById(R.id.tvWind);

        cal = Calendar.getInstance();
        time = cal.getTimeInMillis();
        String str = sdf.format(time);

        if (getIntent().getExtras() != null) {
            String text = getIntent().getExtras().getString(TEXT);
            Boolean humidityChecked = getIntent().getExtras().getBoolean(HUM);
            Boolean windChecked = getIntent().getExtras().getBoolean(WIND);
            Boolean pressureChecked = getIntent().getExtras().getBoolean(PRESS);

            if ((Integer.parseInt(str)) <= 12) textView.setText("Добрый день, " + text);
            else textView.setText("Добрый вечер, " + text);

            textViewCity.setText(getIntent().getExtras().getString(CITY));

            if (humidityChecked) tvHumidity.setText("Humidity: 42%");
            if (windChecked) tvWind.setText("Wind: SSW");
            if (pressureChecked) tvPress.setText("Pressure: 745mmHg");

        }



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPressed) {
                    isPressed = true;
                    startNewActivity();
                }
            }
        });

        Log.d(TAG, "onCreate");
    }

    private void startNewActivity() {
        Intent intent = new Intent(WeatherActivity.this, CreateActionActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isPressed = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
