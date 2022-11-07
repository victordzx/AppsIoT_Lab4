package com.example.lab4.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4.Hito;
import com.example.lab4.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HitoAdapter extends RecyclerView.Adapter<HitoAdapter.ViewHolder> {
    private ArrayList<Hito> listaHito;
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setListaHito(ArrayList<Hito> listaHito) {
        this.listaHito = listaHito;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public View view;

        public ViewHolder(View view) {
            super(view);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).
                inflate(R.layout.item_hitos,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hito hito = listaHito.get(position);

        TextView textEquipo = holder.view.findViewById(R.id.textEquipo);
        TextView textPlayer = holder.view.findViewById(R.id.textPlayer);
        TextView textHito = holder.view.findViewById(R.id.textHito);

        String mostrarTeam= "Equipo: "+ hito.getEquipo();
        String mostrarPlayer= "Jugador: "+ hito.getNombreJugador() + " " + hito.getApellidoJugador();
        String mostrarHito= "Hito: "+ hito.getHito();

        textEquipo.setText(mostrarTeam);
        textPlayer.setText(mostrarPlayer);
        textHito.setText(mostrarHito);
    }

    @Override
    public int getItemCount() {
        return listaHito.size();
    }
}