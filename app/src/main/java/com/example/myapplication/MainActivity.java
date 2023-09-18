package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtRotulo;
    ActivityResultLauncher<Intent> activityLauncher;
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

        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        int somatoriaTelaAnterior = data.getIntExtra("soma", 0);
                        Toast.makeText(MainActivity.this, String.valueOf(somatoriaTelaAnterior), Toast.LENGTH_SHORT).show();
                    }
                    else {  //RESULT_CANCELED
                        Toast.makeText(MainActivity.this, "cancelado",Toast.LENGTH_SHORT).show();
                    }
                });
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
                activityLauncher.launch(intent);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean meuMenu = super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meu_menu, menu );
        return meuMenu;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.item1) {
            messageBox("Item1 clicado");
            onBackPressed();
            return true;
        } else if (item.getItemId() == R.id.item2) {
            messageBox("Item2 clicado");
            System.exit(0);
            return true;
        } else if (item.getItemId() == R.id.item3) {
            Intent intent = new Intent(MainActivity.this, MainActivityChuva.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    private void messageBox(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void tabelaClick(View view) {
        Intent intent = new Intent(MainActivity.this, CampActivity.class);
        startActivity(intent);
    }
}