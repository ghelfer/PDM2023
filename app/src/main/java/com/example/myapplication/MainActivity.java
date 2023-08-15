package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtRotulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TESTE", "passei pelo onCreate!");

        Button btnDois = findViewById(R.id.btnDois);
        btnDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TESTE", "Botao btnDois acionado!");
                txtRotulo.setText("Camaleão!");
            }
        });


        Button btnTres = findViewById(R.id.btnTres);
        Button btnQuatro = findViewById(R.id.btnQuatro);
        btnTres.setOnClickListener(this);
        btnQuatro.setOnClickListener(this);

        txtRotulo = findViewById(R.id.txtRotulo);
    }

    public void eventoClique1(View view) {
        Log.d("TESTE", "Botao eventoClique1 acionado!");
        String aux = txtRotulo.getText().toString();
        Log.d("TESTE",aux);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnTres) {
            Log.d("TESTE", "Botao btnTres acionado!");
        }
        else {
            if (view.getId() == R.id.btnQuatro) {
                Log.d("TESTE", "Botao btnQuatro acionado!");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("valor", "teste para tela 2");
                intent.putExtra("chave", true);
                intent.putExtra("valor1", 1);
                intent.putExtra("valor2", 2);
                startActivityForResult(intent, 0);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TESTE", "passei pelo onStart!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TESTE", "passei pelo onResume!");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK){
                int somatoriaTelaAnterior = data.getIntExtra("soma", 0);
                Toast.makeText(MainActivity.this, String.valueOf(somatoriaTelaAnterior), Toast.LENGTH_SHORT).show();
            }else {
                if (resultCode == RESULT_CANCELED){
                    Toast.makeText(MainActivity.this, "cancelado",Toast.LENGTH_SHORT).show();
                }
                else {
                    Log.d("TESTE", "teste");
                }
            }
        }
    }
}