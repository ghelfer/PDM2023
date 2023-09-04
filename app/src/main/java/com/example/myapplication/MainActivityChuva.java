package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivityChuva extends AppCompatActivity {

    private Spinner spinner;
    private ListView listView;

    String [] dados = {"", "Cumulus","Cumulus nimbus","Cirrus","Stratus"};

    List<String> estados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chuva);

        spinner = findViewById(R.id.spinner1);
        listView = findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.meu_spinner_item, dados);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (!dados[position].isEmpty())
                    messageBox(dados[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        estados = new ArrayList<>();
        estados.add("Acre");
        estados.add("Alagoas");
        estados.add("Amapá");
        estados.add("Amazonas");
        estados.add("Bahia");
        estados.add("Ceará");
        estados.add("Distrito Federal");
        estados.add("Espírito Santo");
        estados.add("Goiás");
        estados.add("Maranhão");
        estados.add("Mato Grosso");
        estados.add("Mato Grosso do Sul");
        estados.add("Minas Gerais");
        estados.add("Pará");
        estados.add("Paraíba");
        estados.add("Paraná");
        estados.add("Pernambuco");
        estados.add("Piauí");
        estados.add("Rio de Janeiro");
        estados.add("Rio Grande do Norte");
        estados.add("Rio Grande do Sul");
        estados.add("Rondônia");
        estados.add("Roraima");
        estados.add("Santa Catarina");
        estados.add("São Paulo");
        estados.add("Sergipe");
        estados.add("Tocantins");


        ArrayAdapter adapter2 = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, estados);
        listView.setAdapter(adapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                messageBox(estados.get(i));
            }
        });



    }


    private void messageBox(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}