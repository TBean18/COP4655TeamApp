package com.cop4655.puggymotivation.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cop4655.puggymotivation.R;
import com.cop4655.puggymotivation.StylesAdapter;
import com.parse.ParseUser;
import java.lang.reflect.Type;

import com.cop4655.puggymotivation.QuotesAdapter;

public class StylesFragment extends Fragment {

    private RecyclerView rvStyles;
    private StylesAdapter adapter;

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
        rvStyles = view.findViewById(R.id.rvStyles);
        adapter = new StylesAdapter(getContext());

        rvStyles.setAdapter(adapter);
        rvStyles.setLayoutManager(new LinearLayoutManager(getContext()));

        //Next step: have each button selection define the style of the quote shown
        //Each style will have different fonts, size, backgrounds, etc


    }
}
