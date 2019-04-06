package com.sersh.notis;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Forms extends Fragment {
    final String LOG_TAG = "form";
    View inflaterView;
    EditText name, time, expirationTime;
    Button ok;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment1 onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflaterView = inflater.inflate(R.layout.fragment_forms, container, false);

            name = (EditText) inflaterView.findViewById(R.id.name);
            time = (EditText) inflaterView.findViewById(R.id.time);
        expirationTime =(EditText)  inflaterView.findViewById(R.id.expirationTime);
        ok = (Button) inflaterView.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registarion.nameST = name.getText().toString();
                Registarion.timeST = Integer.parseInt(time.getText().toString());
                Registarion.expirationTimeST = Integer.parseInt(expirationTime.getText().toString()) ;
                ((Registarion) getActivity()).addBD();
                ((Registarion) getActivity()).showADD();
            }
        });

        return inflaterView;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "Fragment1 onActivityCreated");
    }

    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "Fragment onStart");
    }

    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Fragment onResume");
    }

    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Fragment onPause");
    }

    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "Fragment onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "Fragment onDestroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "Fragment onDestroy");
    }

    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "Fragment onDetach");
    }
    }


