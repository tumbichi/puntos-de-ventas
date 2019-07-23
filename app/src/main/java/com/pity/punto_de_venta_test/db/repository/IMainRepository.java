package com.pity.punto_de_venta_test.db.repository;

import com.pity.punto_de_venta_test.db.models.PuntoVentaModel;

import java.util.ArrayList;

public interface IMainRepository {

    ArrayList<PuntoVentaModel> getPuntosVentasList();
}
