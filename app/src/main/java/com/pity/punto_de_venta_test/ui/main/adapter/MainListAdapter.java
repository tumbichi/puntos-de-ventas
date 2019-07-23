package com.pity.punto_de_venta_test.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pity.punto_de_venta_test.R;
import com.pity.punto_de_venta_test.db.models.PuntoVentaModel;

import java.util.List;

public class MainListAdapter extends BaseAdapter {
    private Context mContext;
    private int layout;
    private List<PuntoVentaModel> mList;


    public MainListAdapter(Context mContext, int layout, List<PuntoVentaModel> mList) {
        this.mContext = mContext;
        this.layout = layout;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public PuntoVentaModel getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder holder;

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ListViewHolder();

            holder.textViewName = convertView.findViewById(R.id.item_list_punto_venta_nombre);
            holder.textViewDireccion = convertView.findViewById(R.id.item_list_punto_venta_direccion);


            convertView.setTag(holder);
        }else{
            holder = (MainListAdapter.ListViewHolder) convertView.getTag();
        }

        String currentName = mList.get(position).getName();
        String currentDireccion = mList.get(position).getAddress();

        holder.textViewName.setText(currentName);
        holder.textViewDireccion.setText(currentDireccion);

        return convertView;
    }

    class ListViewHolder {
        TextView textViewName;
        TextView textViewDireccion;

    }
}
