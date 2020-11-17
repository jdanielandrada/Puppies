package com.example.puppies2.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.puppies2.R;
import com.example.puppies2.entidades.PerroVo;

import java.util.ArrayList;

public class AdaptadorPerros extends RecyclerView.Adapter<AdaptadorPerros.PerrosViewHolder> implements View.OnClickListener{

    ArrayList <PerroVo> listaPerros;
    private View.OnClickListener listener;

    public AdaptadorPerros(ArrayList<PerroVo> listaPerros) {
        this.listaPerros = listaPerros;
    }

    @NonNull
    @Override
    public PerrosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        view.setOnClickListener(this);
        return new PerrosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PerrosViewHolder holder, int position) {
        holder.foto.setImageResource(listaPerros.get(position).getImagenId());
    }

    @Override
    public int getItemCount() {
        return listaPerros.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class PerrosViewHolder extends RecyclerView.ViewHolder {

        //TextView txtInformacion;
        ImageView foto;

        public PerrosViewHolder(@NonNull View itemView) {
            super(itemView);
            //txtInformacion = (TextView) itemView.findViewById(R.id.idInfo);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}
