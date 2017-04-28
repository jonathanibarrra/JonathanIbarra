package com.example.usuario.jonathanibarra;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    EditText et1, et2, et3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void acercaDe(View view) {
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);


        et1 = (EditText) findViewById(R.id.editText1);

        SharedPreferences prefe = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et2 = (EditText) findViewById(R.id.editText2);

        et3 = (EditText) findViewById(R.id.editText3);

        et1.setText(prefe.getString("Primer Valor:",""));
        et2.setText(prefe.getString("Segundo Valor:",""));



        Button btnSumar = (Button) findViewById(R.id.btnSumar);
        final TextView tvResultado = (TextView) findViewById(R.id.textViewResultado);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferencias.edit();
                editor.putString("Primer Valor:",et1.getText().toString());
                editor.putString("Segundo Valor:",et2.getText().toString());
                editor.putString("Segundo Valor:",et3.getText().toString());
                editor.commit();




                int aux1 = Integer.valueOf(et1.getText().toString());
                int aux2 = Integer.valueOf(et2.getText().toString());
                int aux3 = Integer.valueOf(et3.getText().toString());

                int resultado = (aux1  + aux2  + aux3);
                tvResultado.setText(""+resultado);
            }
        });
    }
}