package com.pity.punto_de_venta_test.db.models;

public class PuntoVentaModel {
    private int id;
    private String name;
    private String address;
    private String latitude;
    private String longitude;
    private CiudadModel city;

    public PuntoVentaModel() {

    }

    public String getName() {
        return name;
    }



    public String getAddress() {
        return address;
    }


    public String getLatitude() {
        return latitude;
    }



    public String getLongitude() {
        return longitude;
    }


    public CiudadModel getCity() {
        return city;
    }

}
