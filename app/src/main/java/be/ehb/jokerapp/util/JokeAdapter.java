package be.ehb.jokerapp.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import be.ehb.jokerapp.R;
import be.ehb.jokerapp.model.Joke;

/**
 * Created by Banaan on 20/01/2038. ;)
 */
public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeViewHolder> {

    class JokeViewHolder extends RecyclerView.ViewHolder{

        final TextView tvSetup;
        final Button btnClou;

        public JokeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSetup = itemView.findViewById(R.id.tv_setup);
            btnClou = itemView.findViewById(R.id.btn_clou);
        }
    }

    ArrayList<Joke> items;

    public JokeAdapter() {
        items = new ArrayList<>();
    }

    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View card = layoutInflater.inflate(R.layout.joker_card, parent, false);

        return new JokeViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
        Joke currentJoke = items.get(position);

        holder.tvSetup.setText(currentJoke.getSetup());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItems( ArrayList<Joke> jokes){
        items.clear();
        items.addAll(jokes);
    }
}
