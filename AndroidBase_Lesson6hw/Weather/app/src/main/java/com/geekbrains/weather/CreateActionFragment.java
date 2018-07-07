package com.geekbrains.weather;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by shkryaba on 24/06/2018.
 */

public class CreateActionFragment extends BaseFragment {


    //объявление переменных
    private EditText editTextCountry;
    private EditText editTextName;
    private Button confirmButton;
    private CheckBox checkBoxPressure;
    private CheckBox checkBoxHumidity;
    private boolean pressureChecked;
    private boolean humidityChecked;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //обращаемся к layout который будет содержать наш фрагмент


        return inflater.inflate(R.layout.create_action_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        if(Data.isPressureChecked()) checkBoxPressure.setChecked(true);
        else checkBoxPressure.setChecked(false);
        if(Data.isHumidityChecked()) checkBoxHumidity.setChecked(true);
        else checkBoxHumidity.setChecked(false);
        editTextName.setText(Data.getName());
        editTextCountry.setText(Data.getCountry());

    }

    @Override
    protected void initLayout(View view, Bundle savedInstanceState) {
        //инициализация edittext и листенер на ключи при взаимодействии с ним, когда мы нашимаем enter у нас опускается клавиатура и запускается WeatherFragment
        editTextCountry = (EditText) view.findViewById(R.id.et_country);
        editTextName = (EditText) view.findViewById(R.id.et_name);
        confirmButton = (Button) view.findViewById(R.id.confirm_button);
        checkBoxPressure = (CheckBox) view.findViewById(R.id.checkBox_pressure);
        checkBoxHumidity = (CheckBox) view.findViewById(R.id.checkBox_humidity);



        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Data.setCountry(editTextCountry.getText().toString().trim());
                getBaseActivity().startWeatherFragment(Data.getCountry());
                Data.setName(editTextName.getText().toString().trim());
                TextView textViewName = getBaseActivity().findViewById(R.id.tvUsername);
                textViewName.setText(Data.getName());

                if(checkBoxPressure.isChecked()) Data.setPressureChecked(true);
                if(checkBoxHumidity.isChecked()) Data.setHumidityChecked(true);


                }


        });

       /* editTextCountry.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //получили нажатие
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //опускаем клавиатуру
                    InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    //передаем введенную страну в WeatherFragment
                    Data.setCountry(editTextCountry.getText().toString().trim());
                    getBaseActivity().startWeatherFragment(Data.getCountry());
                    return true;
                }
                return false;
            }
        });
*/




    }
}
