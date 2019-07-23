package com.pity.punto_de_venta_test.ui.main.presenter;

import android.view.View;
import android.widget.AdapterView;

import com.pity.punto_de_venta_test.base.IBasePresenter;
import com.pity.punto_de_venta_test.ui.main.adapter.MainListAdapter;
import com.pity.punto_de_venta_test.ui.main.view.IMainView;

public interface IMainPresenter extends IBasePresenter<IMainView> {

    MainListAdapter getMainAdapter();

}
