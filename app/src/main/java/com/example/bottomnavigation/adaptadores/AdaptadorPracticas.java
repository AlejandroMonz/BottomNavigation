package com.example.bottomnavigation.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.entidades.Devicesvo;
import com.example.bottomnavigation.entidades.Practicasvo;

import java.util.ArrayList;

public class AdaptadorPracticas extends RecyclerView.Adapter<AdaptadorPracticas.PracticasViewHolder>
        implements View.OnClickListener{


    ArrayList<Practicasvo> listaPracticas;
    View.OnClickListener listener;

    public AdaptadorPracticas(ArrayList<Practicasvo> listaPracticas) {
        this.listaPracticas = listaPracticas;
    }

    @NonNull
    @Override
    public PracticasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_practicas,null,false);
        //CODIGO PARA HACERLE MATCH PARENT Y WRAP CONTENT AL RECYCLERVIEW DE LISTA DE PRACTICAS //////////////

        RecyclerView.LayoutParams layoutParams =  new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);

        /////////////////////////////////////////////////////////////////////
        view.setOnClickListener(this);
        return new PracticasViewHolder(view);
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;

    }

    @Override
    public void onBindViewHolder(@NonNull PracticasViewHolder holder, int position) {
        holder.txt_NombrePR.setText(listaPracticas.get(position).getNombrePR());
        holder.txt_descripcion.setText(listaPracticas.get(position).getDescripcion());
        holder.foto.setImageResource(listaPracticas.get(position).getImagenId());
    }

    @Override
    public int getItemCount() {
        return listaPracticas.size();
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class PracticasViewHolder extends RecyclerView.ViewHolder {

        TextView txt_NombrePR, txt_Info, txt_descripcion;
        ImageView foto;

        public PracticasViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_NombrePR = itemView.findViewById(R.id.idNombre);
            txt_descripcion = itemView.findViewById(R.id.idDescripcion);
            foto = itemView.findViewById(R.id.idImagen);
        }
    }
}
