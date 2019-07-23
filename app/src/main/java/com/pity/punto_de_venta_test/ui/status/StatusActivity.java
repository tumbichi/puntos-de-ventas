package com.pity.punto_de_venta_test.ui.status;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pity.punto_de_venta_test.R;
import com.pity.punto_de_venta_test.db.models.PuntoVentaModel;
import com.pity.punto_de_venta_test.db.repository.MainRepository;

public class StatusActivity extends AppCompatActivity {
    private TextView textViewNombre;
    private TextView textViewDireccion;
    private TextView textViewLatitud;
    private TextView textViewLongitud;
    private TextView textViewCiudad;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        getSupportActionBar().hide();

        initViews();

        int position = getIntent().getExtras().getInt("id");
        showPuntoDeVenta(position);


    }

    private void initViews(){
        textViewNombre = findViewById(R.id.view_details_text_view_nombre);
        textViewDireccion = findViewById(R.id.view_details_text_view_direccion);
        textViewCiudad = findViewById(R.id.view_details_text_view_ciudad);
        textViewLatitud = findViewById(R.id.view_details_text_view_latitud);
        textViewLongitud = findViewById(R.id.view_details_text_view_longitud);

    }

    private void showPuntoDeVenta(int position){
        PuntoVentaModel punto = MainRepository.getRepositoryInstance().getPuntosVentasList().get(position);

        textViewNombre.setText(punto.getName());
        textViewDireccion.setText(punto.getAddress());
        textViewCiudad.setText(punto.getCity().getName());
        textViewLatitud.setText(punto.getLatitude());
        textViewLongitud.setText(punto.getLongitude());
    }
}
