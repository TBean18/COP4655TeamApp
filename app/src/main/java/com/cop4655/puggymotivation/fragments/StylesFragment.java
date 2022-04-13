package com.cop4655.puggymotivation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cop4655.puggymotivation.R;
import com.parse.ParseUser;

public class StylesFragment extends Fragment {

    private Button btnStyle1;
    private Button btnStyle2;
    private Button btnStyle3;
    private Button btnStyle4;

    public StylesFragment () {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_styles, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Next step: have each button selection define the style of the quote shown
        //Each style will have different fonts, size, backgrounds, etc

        btnStyle1 = view.findViewById(R.id.btnStyle1);
        btnStyle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Style1 was selected", Toast.LENGTH_SHORT).show();
            }
        });
        btnStyle2 = view.findViewById(R.id.btnStyle2);
        btnStyle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Style2 was selected", Toast.LENGTH_SHORT).show();
            }
        });
        btnStyle3 = view.findViewById(R.id.btnStyle3);
        btnStyle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Style3 was selected", Toast.LENGTH_SHORT).show();
            }
        });
        btnStyle4 = view.findViewById(R.id.btnStyle4);
        btnStyle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Style4 was selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
