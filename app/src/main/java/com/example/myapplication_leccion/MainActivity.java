package com.example.myapplication_leccion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.myapplication_leccion.Adaptador.AdaptadorRevista;
import com.example.myapplication_leccion.Modelos.Revista;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {
    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstOpciones= (ListView)findViewById(R.id.lstListaRevista);
        View header =  getLayoutInflater().inflate( R.layout.lyhederevista, null);
        lstOpciones.addHeaderView(header);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/issues.php?j_id=1",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject JSONlista = new JSONObject(result);
        JSONArray JSONlistaRevista= JSONlista.getJSONArray("data");
        ArrayList<Revista> lstRevista = Revista.JsonObjectsBuild(JSONlistaRevista);
        AdaptadorRevista adapatorRevista = new AdaptadorRevista(this, lstRevista);
        lstOpciones.setAdapter(adapatorRevista);

    }
}