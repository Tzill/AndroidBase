package ru.geekbrains.lifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Fragment1 extends Fragment {
    @Override
    public void onAttach(Context context) {
        Toast.makeText(context, "Fragment1.onAttach()", Toast.LENGTH_SHORT).show();
        //Log.d("Fragment1_log", "Fragment1.onAttach()");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Toast.makeText(getContext(), "Fragment1.onCreate()", Toast.LENGTH_SHORT).show();
        //Log.d("Fragment1_log", "Fragment1.onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout,container, false);
        Toast.makeText(getContext(), "Fragment1.onCreateView()", Toast.LENGTH_SHORT).show();
        //Log.d("Fragment1_log", "Fragment1.onCreateView()");
        //return super.onCreateView(inflater, container, savedInstanceState);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Toast.makeText(getContext(), "Fragment1.onActivityCreated()", Toast.LENGTH_SHORT).show();
        //Log.d("Fragment1_log", "Fragment1.onActivityCreated()");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Toast.makeText(getContext(), "Fragment1.onStart()", Toast.LENGTH_SHORT).show();
        //Log.d("Fragment1_log", "Fragment1.onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        Toast.makeText(getContext(), "Fragment1.onResume()", Toast.LENGTH_SHORT).show();
        //Log.d("Fragment1_log", "Fragment1.onResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        Toast.makeText(getContext(), "Fragment1.onPause()", Toast.LENGTH_SHORT).show();
        //Log.d("Fragment1_log", "Fragment1.onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Toast.makeText(getContext(), "Fragment1.onStop()", Toast.LENGTH_SHORT).show();
        //Log.d("Fragment1_log", "Fragment1.onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Toast.makeText(getContext(), "Fragment1.onDestroyView()", Toast.LENGTH_SHORT).show();
        //Log.d("Fragment1_log", "Fragment1.onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Toast.makeText(getContext(), "Fragment1.onDetach()", Toast.LENGTH_SHORT).show();
        //Log.d("Fragment1_log", "Fragment1.onDetach()");
        super.onDetach();
    }
}
