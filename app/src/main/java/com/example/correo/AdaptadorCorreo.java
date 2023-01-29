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
    public AdaptadorCorreo(List<Correo> correos) {
        this.correos = correos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView de;
        TextView asunto;

        public ViewHolder(View view) {
            super(view);
            de = (TextView) view.findViewById(R.id.delbl);
            asunto = (TextView) view.findViewById(R.id.asuntolbl);
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
        viewHolder.getDeLbl().setText(correos.get(position).getDe());
        viewHolder.getAsuntoLbl().setText(correos.get(position).getAsunto());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(correos.get(position).de, correos.get(position).asunto);
            }
        });
    }

    @Override
    public int getItemCount() {
        return correos.size();
    }
}
