package com.example.lab4.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4.R;

import java.util.ArrayList;

public class LineupAdapter extends RecyclerView.Adapter<LineupAdapter.ViewHolder> {
    private ArrayList<String> listaPlayers;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView;

        public ViewHolder(View view){
            super(view);
            textView = (TextView) view.findViewById(R.id.textView_nameJugador);
        }
        public TextView getTextView(){
            return getTextView();
        }

    }

    public LineupAdapter(ArrayList<String> dataSet){
        listaPlayers=dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_lineups,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(listaPlayers.get(position));
    }

    @Override
    public int getItemCount() {
        return listaPlayers.size();
    }
}
