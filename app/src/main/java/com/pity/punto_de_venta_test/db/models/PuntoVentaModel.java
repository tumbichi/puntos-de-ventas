package com.pity.punto_de_venta_test.db.models;

public class PuntoVentaModel {
    private int id;
    private String name;
    private String direccion;
    private String latitud;
    private String longitud;
    private CiudadModel ciudad;

    public PuntoVentaModel() {

    }

    public PuntoVentaModel(int id, String name, String direccion, String latitud, String longitud, CiudadModel ciudad) {
        this.id = id;
        this.name = name;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public CiudadModel getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadModel ciudad) {
        this.ciudad = ciudad;
    }
}
