package com.sersh.notis;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


public class AddRemuvView extends Fragment implements OnClickListener {
    View inflaterView;
    Button Add, Remuv, Vieew;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         inflaterView = inflater.inflate(R.layout.fragment_add_remuv_view, container, false);
         Add = (Button) inflaterView.findViewById(R.id.adD);
        Remuv = (Button) inflaterView.findViewById(R.id.removE);
        Vieew = (Button) inflaterView.findViewById(R.id.vieW);
        Add.setOnClickListener(this);
        Remuv.setOnClickListener(this);
        Vieew.setOnClickListener(this);
        return inflaterView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.adD:
                ((Registarion) getActivity()).showFormd();
                break;
            case R.id.vieW:
                ((Registarion) getActivity()).viewW();
                break;
            case R.id.removE:
                ((Registarion) getActivity()).Remove();
                break;
        }
    }
}
