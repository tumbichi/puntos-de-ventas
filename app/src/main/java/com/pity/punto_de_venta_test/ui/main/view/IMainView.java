package com.pity.punto_de_venta_test.ui.main.view;

import com.pity.punto_de_venta_test.base.IBaseView;

public interface IMainView extends IBaseView {
    void toast(String text);
    void navigateToStatus(int id);
}
