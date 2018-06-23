package com.geekbrains.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//1. Запишите последовательности вызова методов при различных действиях пользователей:
// при запуске приложения, - onCreate()->onStart()->onResume()
// при переворачивании устройства, - onPause()->onStop()->onDestroy()->onCreate()->onStart()->onResume()
// при нажатии кнопки «Домой»… - onPause()->onStop()
// при восставновлении из свернутого - onRestart()->onStart()->onResume()
// при завершении приложения - onPause()->onStop()
//2. В activity погодного приложения создайте пользовательский интерфейс в виде вывода
// на экран погодных значений.
//3. Запустите интерфейс на эмуляторе.
//4. *Внесите изменения в приложение LifeCycle, чтобы сообщения о жизненном цикле
// выводились не только всплывающими сообщениями, но и в logcat.

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "WeatherActivity";

    private static final DateFormat sdf = new SimpleDateFormat("dd MM");
    private static final int DAY_MILLIS = 86400000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Log.d(TAG, "onCreate");
        Toast.makeText(getApplicationContext(), "onCreate()", Toast.LENGTH_SHORT).show();

        TextView day1 = (TextView) findViewById(R.id.day1);
        TextView day2 = (TextView) findViewById(R.id.day2);
        TextView day3 = (TextView) findViewById(R.id.day3);

        Calendar cal = Calendar.getInstance();
        long time = cal.getTimeInMillis();

        day1.setText(sdf.format(time) + "  +25 C");
        time += DAY_MILLIS;
        day2.setText(sdf.format(time) + "  +24 C");
        time += DAY_MILLIS;
        day3.setText(sdf.format(time) + "  +20 C");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
    }
}
