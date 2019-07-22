package com.pity.punto_de_venta_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pity.punto_de_venta_test.db.HttpClient;
import com.pity.punto_de_venta_test.db.OnHttpRequestComplete;
import com.pity.punto_de_venta_test.db.Response;
import com.pity.punto_de_venta_test.db.models.PuntoVentaModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textViewNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        textViewNombre = findViewById(R.id.view_details_text_view_nombre);
        createClient();
    }

    private void createClient(){

        HttpClient client = new HttpClient(new OnHttpRequestComplete() {
            @Override
            public void onComplete(Response status) {
                if (status.isSuccess()){
                    Gson gson = new GsonBuilder().create();
                    try {
                        JSONObject jsonObject = new JSONObject(status.getResult());
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        ArrayList<PuntoVentaModel> puntos = new ArrayList<>();
                        for (int i = 0 ; i < jsonArray.length() ; i++){
                            String punto = jsonArray.getString(i);
                            PuntoVentaModel puntoVenta = gson.fromJson(punto, PuntoVentaModel.class);
                            puntos.add(puntoVenta);
                            textViewNombre.setText(puntoVenta.getName());

                        }

                    }catch (Exception e){

                    }
                    toast(status.getResult());
                }

            }
        });

        client.excecute("http://zenda.tmt.com.ar:84/api/v1/nivea/training/nodes");
    }

    private void toast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

   /* public List<PuntoVentaModel> readJSONStream(InputStream in) throws IOException {

        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));

        try {
            // Leer Array
            return leerPuntosDeVentas(reader);
        } finally {
            reader.close();
        }
    }

    private List<PuntoVentaModel> leerPuntosDeVentas(JsonReader reader) throws IOException {

        // Lista temporal
        ArrayList puntos = new ArrayList();

        reader.beginArray();
        while (reader.hasNext()) {
            // Leer objeto
            puntos.add(leerPunto(reader));
        }
        reader.endArray();
        return puntos;
    }*/

    /*private PuntoVentaModel leerPunto(JsonReader reader) throws IOException {
        Integer id = null;
        String nombre = null;
        String direccion = null;
        String latitud = null;
        String longitud = null;
        CiudadModel ciudad = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "id":
                    id = reader.nextInt();
                    break;
                case "name":
                    nombre = reader.nextString();
                    break;
                case "address":
                    direccion = reader.nextString();
                    break;
                case "latitude":
                    latitud = reader.nextString();
                    break;
                case "longitude":
                    longitud = reader.nextString();
                    break;
                case "city":
                    ciudad = reader.;
                    break;

                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return new Animal(especie, descripcion, imagen);
    }*/


}
