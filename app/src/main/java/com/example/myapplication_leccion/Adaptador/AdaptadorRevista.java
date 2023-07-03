package com.example.myapplication_leccion.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication_leccion.Modelos.Revista;
import com.example.myapplication_leccion.R;

import java.util.ArrayList;

public class AdaptadorRevista extends ArrayAdapter<Revista> {
    public AdaptadorRevista(Context context, ArrayList<Revista> datos) {
        super(context, R.layout.lyrevista, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyrevista, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.idNombre);
        lblNombre.setText(getItem(position).getNombres());
        TextView lblSubtitulo = (TextView)item.findViewById(R.id.id);
        lblSubtitulo.setText(getItem(position).getId());


        ImageView imageView = (ImageView)item.findViewById(R.id.imgsPortada);
        Glide.with(this.getContext())
                .load(getItem(position).getUrlavatar())
                .into(imageView);


        return(item);
    }
}