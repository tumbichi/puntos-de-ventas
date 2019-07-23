package com.pity.punto_de_venta_test.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseView<TPresenter extends IBasePresenter> extends AppCompatActivity
        implements IBaseView {

    public TPresenter mPresenter;


    public abstract TPresenter createBasePresenter(final Context context);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mPresenter == null) {
            mPresenter = createBasePresenter(this);
        }

        if (mPresenter != null) {
            mPresenter.onCreate(savedInstanceState);
            getSupportActionBar().hide();

        }

    }

}