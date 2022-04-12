package com.cop4655.puggymotivation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.ParseFile;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.ViewHolder> {

    private Context context;
    private List<Quotes> quotes;

    public QuotesAdapter(Context context, List<Quotes> quotes){
        this.context = context;
        this.quotes = quotes;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_quote, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Quotes quote = quotes.get(position);
        holder.bind(quote);
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvAuthor;
        private TextView tvPhrase;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvPhrase = itemView.findViewById(R.id.tvPhrase);
        }

        public void bind(Quotes quote) {
            tvPhrase.setText(quote.getPhrase());
            tvAuthor.setText(quote.getAuthor());
        }
    }
}
