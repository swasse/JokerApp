package be.ehb.jokerapp.util;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import be.ehb.jokerapp.R;
import be.ehb.jokerapp.model.Joke;

/**
 * Created by Banaan on 20/01/2038. ;)
 */
public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeViewHolder> implements Filterable {

    class JokeViewHolder extends RecyclerView.ViewHolder {

        final TextView tvSetup;
        final Button btnClou;

        final View.OnClickListener detailListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //welke card?
                int position = getAdapterPosition();
                //data in bundle om door te geven
                Bundle data = new Bundle();
                data.putSerializable("passedJoke", items.get(position));
                //navigatie starten
                Navigation.findNavController(view).navigate(R.id.jokelist_to_details, data);
            }
        };

        public JokeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSetup = itemView.findViewById(R.id.tv_setup);
            btnClou = itemView.findViewById(R.id.btn_clou);
            btnClou.setOnClickListener(detailListener);
        }
    }

    private ArrayList<Joke> items;
    private final ArrayList<Joke> OGItems;

    public JokeAdapter() {
        items = new ArrayList<>();
        OGItems = new ArrayList<>();
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

    public void addItems(ArrayList<Joke> jokes) {
        items.clear();
        items.addAll(jokes);
        OGItems.clear();
        OGItems.addAll(jokes);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String input = charSequence.toString();
                items = OGItems;
                if (!input.isEmpty()) {
                    ArrayList<Joke> tempList = new ArrayList<>();

                    for (Joke element : items) {
                        if (element.getSetup().contains(input)) {
                            tempList.add(element);
                        }
                    }
                    items = tempList;
                }
                return null;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                notifyDataSetChanged();
            }
        };
    }
}
