package com.cop4655.puggymotivation.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cop4655.puggymotivation.Quotes;
import com.cop4655.puggymotivation.QuotesAdapter;
import com.cop4655.puggymotivation.R;
import com.parse.FindCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class QuotesFragment extends Fragment {

    public static final String TAG = "QuotesFragment";
    private RecyclerView rvQuotes;

    protected QuotesAdapter adapter;
    protected List<Quotes> allQuotes;
    public QuotesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_quotes, container, false);
        return inflater.inflate(R.layout.fragment_quotes, container, false);
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        rvQuotes = view.findViewById(R.id.rvQuotes);
//        allQuotes = new ArrayList<>();
//        adapter = new QuotesAdapter(getContext(), allQuotes);
//
//        rvQuotes.setAdapter(adapter);
//        rvQuotes.setLayoutManager(new LinearLayoutManager(getContext()));
//        queryPosts();
//
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvQuotes = view.findViewById(R.id.rvQuotes);
        allQuotes = new ArrayList<>();
        adapter = new QuotesAdapter(getContext(), allQuotes);

        rvQuotes.setAdapter(adapter);
        rvQuotes.setLayoutManager(new LinearLayoutManager(getContext()));
        queryQuotes();

    }


    protected void queryQuotes() {
        ParseQuery<Quotes> query = ParseQuery.getQuery(Quotes.class);
        query.addDescendingOrder(Quotes.KEY_CREATED_KEY);
        query.findInBackground(new FindCallback<Quotes>() {
            @Override
            public void done(List<Quotes> quotes, ParseException e) {
                if(e != null){
                    Log.e(TAG, "Issue with getting quotes", e);
                    return;
                }
                for(Quotes quote : quotes){
                    Log.i(TAG, "Phrase: " + quote.getPhrase() + ", Author: " + quote.getAuthor());

                }
                allQuotes.addAll(quotes);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
