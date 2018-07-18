package com.geekbrains.weather;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by shkryaba on 24/06/2018.
 */

public class CreateActionFragment extends BaseFragment {

    //объявление переменных
    private EditText editTextCountry;
    private RecyclerView recyclerView;
    OnHeadlineSelectedListener mCallback;
    private LinearLayout linearLayout;
    private ArrayList<String> cityList;
    private Button historyButton;
    private Context context;
    private TextInputLayout textInputLayout;

    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(ArrayList<String> position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        Toast.makeText(getContext(), "onAttachAction", Toast.LENGTH_SHORT).show();

        try {
            mCallback = (OnHeadlineSelectedListener) getBaseActivity().getAnotherFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(getBaseActivity().getAnotherFragment().toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //обращаемся к layout который будет содержать наш фрагмент
        return inflater.inflate(R.layout.create_action_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void initLayout(View view, Bundle savedInstanceState) {
        initCountryList();

        recyclerView = view.findViewById(R.id.list_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        CustomAdapter customAdapter = new CustomAdapter(getContext(), cityList, mCallback);
        recyclerView.setAdapter(customAdapter);

        //инициализация edittext и листенер на ключи при взаимодействии с ним, когда мы нашимаем enter у нас опускается клавиатура и запускается WeatherFragment
        editTextCountry = (EditText) view.findViewById(R.id.et_country);

        editTextCountry.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                     String s = (editTextCountry.getText().toString());
                     char[] ch = s.toCharArray();
                     for(int i=0; i<ch.length; i++){
                         if (!Character.isAlphabetic(ch[i])){
                             showError("Not alphabetical!");

                         }else {
                             hideError();
                             InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                             imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                             String country = editTextCountry.getText().toString().trim();
                             ArrayList<String> arrayList = new ArrayList<>();
                             arrayList.add(country);
                             mCallback.onArticleSelected(arrayList);
                             return true;
                         }
                     }






                }
                return false;
            }
        });

        textInputLayout = view.findViewById(R.id.text_input);




        historyButton = (Button)view.findViewById(R.id.history_button);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "click", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, HistoryActivity.class);

                startActivity(intent);
            }
        });


    }

    private void showError(String s){
        textInputLayout.setError(s);
    }

    private void hideError(){
        textInputLayout.setError("");
    }
    private void initCountryList() {
        cityList = new ArrayList<>();
        cityList.add("Moscow");
        cityList.add("St. Peterburg");
        cityList.add("Kazan");
    }
}