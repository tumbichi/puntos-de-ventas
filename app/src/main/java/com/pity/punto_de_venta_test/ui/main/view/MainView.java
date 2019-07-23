package com.pity.punto_de_venta_test.ui.main.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.pity.punto_de_venta_test.R;
import com.pity.punto_de_venta_test.base.BaseView;
import com.pity.punto_de_venta_test.ui.main.presenter.IMainPresenter;
import com.pity.punto_de_venta_test.ui.main.presenter.MainPresenter;
import com.pity.punto_de_venta_test.ui.status.StatusActivity;

public class MainView extends BaseView<IMainPresenter> implements IMainView, AdapterView.OnItemClickListener{




    @Override
    public IMainPresenter createBasePresenter(Context context) {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();



    }


    @Override
    public void toast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToStatus(int puntoID) {
        Intent statusIntent = new Intent(this, StatusActivity.class);
        statusIntent.putExtra("id", puntoID);
        startActivity(statusIntent);
    }

    private void initViews(){
        ListView listView = findViewById(R.id.main_list_view);
        listView.setOnItemClickListener(this);
        listView.setAdapter(mPresenter.getMainAdapter());
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        navigateToStatus(position);
    }
}
