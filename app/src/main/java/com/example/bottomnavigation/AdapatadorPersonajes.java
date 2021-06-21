package com.example.bottomnavigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapatadorPersonajes extends RecyclerView.Adapter<AdapatadorPersonajes.ViewHolderPersonajes>
implements View.OnClickListener{

    ArrayList<PersonajesVo> listapersonajes;//Se crea el array en base a la clase que creamos "PersonajesVo" y la nombra lista de personajes
    View.OnClickListener listener;

    public AdapatadorPersonajes(ArrayList<PersonajesVo> listapersonajes) {//Y en base a ese array creamos el constructor que reciba esa lista
        this.listapersonajes = listapersonajes;
    }

    @NonNull
    @Override
    public ViewHolderPersonajes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_personajes,null,false);//Ahora vamos a inflar mediante un view ese itemlist

        view.setOnClickListener(this);

        return new ViewHolderPersonajes(view); //Retornamos el elemento View holder personajes y le mandamos el view que creamos ya que el constructor que creamos recibe un itemview.
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersonajes holder, int position) {
        holder.EtiNombre.setText(listapersonajes.get(position).getNombre());
        holder.EtiInfo.setText(listapersonajes.get(position).getInfo());
        holder.foto.setImageResource(listapersonajes.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return listapersonajes.size();//Debemos poner el tamaño de lista personajes y que retorne.
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolderPersonajes extends RecyclerView.ViewHolder {//Y aqui en ViewHolderPersonajes debemos hacer referencias a esos componentes graficos

        TextView EtiNombre, EtiInfo;
        ImageView foto;

        public ViewHolderPersonajes(@NonNull View itemView) {
            super(itemView);
            EtiNombre = (TextView)itemView.findViewById(R.id.idNombre);
            EtiInfo = (TextView)itemView.findViewById(R.id.idInfo);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}
