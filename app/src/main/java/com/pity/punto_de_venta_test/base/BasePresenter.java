package com.pity.punto_de_venta_test.base;

import android.content.Context;
import android.os.Bundle;

public abstract class BasePresenter<TView extends IBaseView> implements IBasePresenter<TView> {

    protected Context mContext;
    protected TView mView;


    public BasePresenter(Context context) {
        mContext = context;
    }



    @Override
    public void onCreate(Bundle savedState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

}
