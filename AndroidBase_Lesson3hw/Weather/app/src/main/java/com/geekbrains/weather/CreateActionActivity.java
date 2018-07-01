package com.geekbrains.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by shkryaba on 24/06/2018.
 */

public class CreateActionActivity extends AppCompatActivity {

    private static final String TEXT = "TEXT";
    private static final String HUM = "HUM";
    private static final String WIND = "WIND";
    private static final String PRESS = "PRESS";
    private static final String CITY = "CITY";
    private EditText editText;
    private EditText editTextCity;
    private boolean checkedHumidity;
    private boolean checkedWind;
    private boolean checkedPressure;
    private String cityName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_action_activity);

        editText = findViewById(R.id.etname);
        editTextCity = findViewById(R.id.etcity);


    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        checkedHumidity = ((CheckBox)findViewById(R.id.cb_humidity)).isChecked();
        checkedWind = ((CheckBox)findViewById(R.id.cb_wind)).isChecked();
        checkedPressure = ((CheckBox)findViewById(R.id.cb_pressure)).isChecked();
        cityName = String.valueOf(editTextCity.getText());

        Intent intent = new Intent(CreateActionActivity.this, WeatherActivity.class);
        intent.putExtra(TEXT, editText.getText().toString().trim());
        intent.putExtra(HUM, checkedHumidity);
        intent.putExtra(WIND, checkedWind);
        intent.putExtra(PRESS, checkedPressure);
        intent.putExtra(CITY, cityName);
        startActivity(intent);
        finish();
    }
}
