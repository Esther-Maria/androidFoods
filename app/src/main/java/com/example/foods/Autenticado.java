package com.example.foods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Autenticado extends AppCompatActivity {
    TextView text;
    private ChipGroup chip_Group;
    private Button btnPronto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_autenticado);
        Intent intent2 = getIntent();

        String nomeRecebido = (String) intent2.getSerializableExtra("nome_apelido");
        text = findViewById(R.id.textView);

        text.setText("Olá, "+ nomeRecebido);

        chip_Group = findViewById(R.id.chipGroup);
        btnPronto = findViewById(R.id.btn_pronto);

        btnPronto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedId = chip_Group.getCheckedChipId();
                if (selectedId != View.NO_ID) {
                    Chip selectedChip = findViewById(selectedId);
                    String selectedGenre = selectedChip.getText().toString();

                    Intent intent = new Intent(Autenticado.this, MusicasRelacionadasActivity.class);
                    intent.putExtra("selectedGenre", selectedGenre);
                    startActivity(intent);
                }
            }
        });

    }

}