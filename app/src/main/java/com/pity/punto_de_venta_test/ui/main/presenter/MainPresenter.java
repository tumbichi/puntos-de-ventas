package com.pity.punto_de_venta_test.ui.main.presenter;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import com.pity.punto_de_venta_test.R;
import com.pity.punto_de_venta_test.base.BasePresenter;
import com.pity.punto_de_venta_test.db.models.PuntoVentaModel;
import com.pity.punto_de_venta_test.db.repository.IMainRepository;
import com.pity.punto_de_venta_test.db.repository.MainRepository;
import com.pity.punto_de_venta_test.ui.main.adapter.MainListAdapter;
import com.pity.punto_de_venta_test.ui.main.view.IMainView;

import java.util.ArrayList;


public class MainPresenter extends BasePresenter<IMainView> implements IMainPresenter {

    private IMainRepository mRepository;
    private ArrayList<PuntoVentaModel> puntosVenta;

    public MainPresenter(Context context) {
        super(context);
        mRepository = MainRepository.getRepositoryInstance();
    }




    @Override
    public MainListAdapter getMainAdapter() {
        puntosVenta = mRepository.getPuntosVentasList();
        return new MainListAdapter(mContext, R.layout.item_list_view_puntos_de_ventas, puntosVenta);
    }



}
