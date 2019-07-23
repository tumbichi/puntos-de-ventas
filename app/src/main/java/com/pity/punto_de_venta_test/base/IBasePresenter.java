package com.pity.punto_de_venta_test.base;

import android.os.Bundle;

public interface IBasePresenter<TView extends IBaseView> {



    void onCreate(Bundle savedState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();




}