package com.example.myapplication_leccion.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {
    private String nombres;
    private String id;
    private String urlavatar;
    public Revista(JSONObject a) throws JSONException {
        nombres = a.getString("name").toString() + " " + a.getString("last_name").toString();
        id= a.getString("journal_id").toString() ;
        urlavatar = a.getString("portada").toString() ;
    }
    public static ArrayList<Revista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList< Revista> revista = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            revista.add(new  Revista(datos.getJSONObject(i)));
        }
        return revista;
    }
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = getId();
    }

    public String getUrlavatar() {
        return urlavatar;
    }

    public void setUrlavatar(String urlavatar) {
        this.urlavatar = urlavatar;
    }
}