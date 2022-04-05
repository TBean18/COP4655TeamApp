package com.cop4655.puggymotivation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cop4655.puggymotivation.R;
import com.parse.ParseUser;

public class ProfileFragment extends Fragment {
    private Button logout;
    public ProfileFragment () {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logout = view.findViewById(R.id.buttonLogout);
        logout.setOnClickListener(view1 -> {
            ParseUser.logOut();
            getActivity().finish();
        });
    }
}
