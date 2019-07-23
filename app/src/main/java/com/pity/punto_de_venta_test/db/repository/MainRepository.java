package com.pity.punto_de_venta_test.db.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pity.punto_de_venta_test.db.network.HttpClient;
import com.pity.punto_de_venta_test.db.network.OnHttpRequestComplete;
import com.pity.punto_de_venta_test.db.network.Response;
import com.pity.punto_de_venta_test.db.models.PuntoVentaModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainRepository implements IMainRepository, OnHttpRequestComplete {

    private static MainRepository mainRepository;
    private HttpClient mHttpClient;
    private ArrayList<PuntoVentaModel> puntosVentasList;
    private String endPoint = "http://zenda.tmt.com.ar:84/api/v1/nivea/training/nodes";

    private MainRepository(){
        mHttpClient = new HttpClient(this);
        mHttpClient.excecute(endPoint);
    }


    public static MainRepository getRepositoryInstance(){
        if (mainRepository == null) mainRepository = new MainRepository();
        return mainRepository;
    }

    @Override
    public ArrayList<PuntoVentaModel> getPuntosVentasList(){
        if (puntosVentasList == null) mHttpClient.excecute(endPoint);
        return puntosVentasList;
    }

    @Override
    public void onComplete(Response status) {

        if (status.isSuccess()) {
            Gson gson = new GsonBuilder().create();
            try {
                JSONObject jsonObject = new JSONObject(status.getResult());
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                ArrayList<PuntoVentaModel> puntos = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    String punto = jsonArray.getString(i);
                    PuntoVentaModel puntoVenta = gson.fromJson(punto, PuntoVentaModel.class);
                    puntos.add(puntoVenta);
                }
                puntosVentasList = puntos;


            } catch (Exception e) {

            }



        }

    }
}
