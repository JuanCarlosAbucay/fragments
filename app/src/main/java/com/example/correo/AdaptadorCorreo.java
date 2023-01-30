package com.example.correo;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdaptadorCorreo extends RecyclerView.Adapter<AdaptadorCorreo.ViewHolder> {
    private final List<Correo> correos;
    CorreosListener listener;
    public AdaptadorCorreo(List<Correo> correos) {
        this.correos = correos;
    }
    public AdaptadorCorreo(List<Correo> correos, CorreosListener listener){
        this.correos = correos;
        this.listener = listener;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView de;
        TextView asunto;

        public ViewHolder(View view) {
            super(view);
            de = (TextView) view.findViewById(R.id.delbl);
            asunto = (TextView) view.findViewById(R.id.asuntolbl);
        }

        public void bindCorreo(Correo correo){
            de.setText(correo.getDe());
            asunto.setText(correo.getAsunto());
        }

        public TextView getDeLbl() {
            return de;
        }
        public TextView getAsuntoLbl() {
            return asunto;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_dades, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        Correo correo = correos.get(position);
        Log.d("Text", correo.texto);
        viewHolder.bindCorreo(correo);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCorreoSeleccionado(correo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return correos.size();
    }

}
