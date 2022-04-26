package com.cop4655.puggymotivation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cop4655.puggymotivation.fragments.QuotesFragment;

import java.util.ArrayList;
import java.util.List;

public class StylesAdapter extends RecyclerView.Adapter<StylesAdapter.ViewHolder> {

    private Context context;
    private List<Integer> styles = new ArrayList<>();

    public StylesAdapter(Context context){
        this.context = context;
        TypedArray stylesArray = context.getResources().obtainTypedArray(R.array.quoteStyles);
        for (int i = 0; i < stylesArray.length(); i++) {
        this.styles.add(stylesArray.getResourceId(i,0));

        }


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_quotestyle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int resID = styles.get(position);
        holder.bind(resID);
    }

    @Override
    public int getItemCount() {
        return styles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.buttonQuoteStyle);
        }

        public void bind(int resID) {
            button.setTextAppearance(resID);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    QuotesFragment.quoteStyle = resID;
                }
            });
//            Set Text
            TypedArray array = context.obtainStyledAttributes(resID, new int[]{android.R.attr.text});
            button.setText(array.getString(0));
        }
    }
}
