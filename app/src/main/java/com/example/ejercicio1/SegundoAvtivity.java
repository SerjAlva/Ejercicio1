package com.example.ejercicio1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class SegundoAvtivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvEdad;
    private TextView tvHoroscopo;
    private TextView tvRFC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundo_avtivity);

        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvEdad = (TextView)findViewById(R.id.tvEdad);
        tvHoroscopo = (TextView)findViewById(R.id.tvHoroscopo);
        tvRFC = (TextView)findViewById(R.id.tvRFC);

        String nombreCompleto = getIntent().getStringExtra("nombre");
        String edad = getIntent().getStringExtra("edad");
        String signo = getIntent().getStringExtra("signo");
        String rfc = getIntent().getStringExtra("rfc");

        tvNombre.setText(nombreCompleto);
        tvEdad.setText(edad);
        tvHoroscopo.setText(signo);
        tvRFC.setText(rfc);
    }



    public void Anterior(View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
}
