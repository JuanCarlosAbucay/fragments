package com.example.correo;

import android.location.GnssAntennaInfo;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FragmentListado extends Fragment {
    private static RecyclerView lstListado;
    private static List<Correo> datos = new ArrayList<>();
    CorreosListener listener = null;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        for (int i = 0; i < 10; i++) {
            datos.add(new Correo("Persona " + i, "Asunto del correo " + i, "Texto del correo" + i));
        }
        AdaptadorCorreo adaptador = new AdaptadorCorreo(datos, new CorreosListener() {
            @Override
            public void onCorreoSeleccionado(Correo correo) {
                if (listener != null){
                    listener.onCorreoSeleccionado(correo);
                }
            }
        });
        lstListado = getView().findViewById(R.id.lstListado);
        lstListado.setLayoutManager(new LinearLayoutManager(this.getContext()));
        lstListado.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));
        lstListado.setAdapter(adaptador);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    public void setCorreosListener(CorreosListener l ){
        listener = l;
    }

    public void setCorreosListener(Consumer<Correo> seleccion){
        listener = new CorreosListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onCorreoSeleccionado(Correo correo) {
                seleccion.accept(correo);
            }
        };
    }
}