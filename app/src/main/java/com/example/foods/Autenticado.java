package com.example.foods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Autenticado extends AppCompatActivity {
    TextView text;
    SearchView Search;
    ListView Lista;
    ArrayList<String> lista = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_autenticado);
        Intent intent2 = getIntent();

        String nomeRecebido = (String) intent2.getSerializableExtra("nome_apelido");
        text = findViewById(R.id.textView);

        text.setText("Olá, "+ nomeRecebido);

        Search = findViewById(R.id.searchView);
        Lista = findViewById(R.id.ListView);
        lista.add("Texto 1");
        lista.add("Texto 2");
        lista.add("Texto 3");
        lista.add("Texto 4");
        lista.add("Texto 5");
        lista.add("Texto 6");
        arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,lista
        );
        Lista.setAdapter(arrayAdapter);
        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        getApplicationContext(),
                        "Cliquei",
                        Toast.LENGTH_SHORT
                ).show();

            }
        });


    }
}