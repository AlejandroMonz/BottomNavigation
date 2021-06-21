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

import java.util.ArrayList;

public class AdaptadorDevices extends RecyclerView.Adapter<AdaptadorDevices.DevicesViewHolder>
implements View.OnClickListener{

    ArrayList<Devicesvo> listaDevices;

    View.OnClickListener listener;

    public AdaptadorDevices(ArrayList<Devicesvo> listaDevices) {
        this.listaDevices = listaDevices;
    }

    @NonNull
    @Override
    public AdaptadorDevices.DevicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_devices,null,false);
        //CODIGO PARA HACERLE MATCH PARENT Y WRAP CONTENT AL RECYCLERVIEW DE LISTA DE PRACTICAS //////////////

        RecyclerView.LayoutParams layoutParams =  new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);

        /////////////////////////////////////////////////////////////////////
        view.setOnClickListener(this);
        return new DevicesViewHolder(view);
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDevices.DevicesViewHolder holder, int position) {

        holder.txt_nombreDevice.setText(listaDevices.get(position).getNombreDevice());
        holder.img_device.setImageResource(listaDevices.get(position).getImagenDevice());
    }

    @Override
    public int getItemCount() {
        return listaDevices.size();

    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class DevicesViewHolder extends RecyclerView.ViewHolder {

        TextView txt_nombreDevice;
        ImageView img_device;
        public DevicesViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_nombreDevice = itemView.findViewById(R.id.idNombreDevice);
            img_device = itemView.findViewById(R.id.idImagenDevice);
        }
    }
}