package com.cop4655.puggymotivation.fragments;

import android.content.Intent;
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
import androidx.fragment.app.FragmentTransaction;

import com.cop4655.puggymotivation.MainActivity;
import com.cop4655.puggymotivation.R;
import com.cop4655.puggymotivation.ScheduleActivity;
import com.parse.ParseUser;

public class ProfileFragment extends Fragment {
    private Button logout;
    private Button schedule;
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
        TextView profileName = view.findViewById(R.id.profile_name);
        profileName.setText(ParseUser.getCurrentUser().getUsername());
        logout = view.findViewById(R.id.buttonLogout);
        logout.setOnClickListener(view1 -> {
            ParseUser.logOut();
            getActivity().finish();
        });


        
        schedule = view.findViewById(R.id.buttonSchedule);
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Set Schedule!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ScheduleActivity.class);
                startActivity(intent);
            }
        });
        
    }
}
