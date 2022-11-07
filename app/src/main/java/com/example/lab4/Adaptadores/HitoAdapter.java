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

    @NonNull
    @Override
    public HitoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_hitos,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HitoAdapter.ViewHolder holder, int position) {
        Hito hito = listaHito.get(position);

        String mostrarTeam= "Equipo: "+ hito.getEquipo();
        String mostrarPlayer= "Jugador: "+ hito.getNombreJugador() + " " + hito.getApellidoJugador();
        String mostrarHito= "Hito: "+ hito.getHito();

        holder.equipo.setText(mostrarTeam);
        holder.jugador.setText(mostrarPlayer);
        holder.hito.setText(mostrarHito);
    }

    @Override
    public int getItemCount() {
        return listaHito.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView equipo, jugador, hito;
        public ViewHolder(@NonNull View view) {
            super(view);
            equipo = view.findViewById(R.id.textEquipo);
            jugador = view.findViewById(R.id.textPlayer);
            hito = view.findViewById(R.id.textHito);
        }
    }
}