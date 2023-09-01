package com.example.foods;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;

public class EsqueciSenha extends AppCompatActivity {
    private EditText email;
    private TextView teste;
    private Button btRecuperar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);
        email = findViewById(R.id.editTextTextEmailAddress);
        btRecuperar = findViewById(R.id.btnRecuperar);
        teste = findViewById(R.id.textView);

        btRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidarLogin();
            }
        });


    }
    private boolean verificado() {
        boolean retorno = true;
        if (email.getText().toString().length() == 0) {
            email.setError("Digite um email.");
            retorno = false;
        }

        return retorno;

    }
    private void Dialog(String Titulo,String Mensagem){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(Titulo)
                .setMessage(Mensagem)
                .show();
    }

    private void ValidarLogin(){
        String eml = email.getText().toString();

        Matcher matcher = Patterns.EMAIL_ADDRESS.matcher(eml);
        if (verificado()){
            if (matcher.matches()) {
                System.out.println("O endereço de e-mail "+ eml + " é válido.");
                Dialog("Sucesso","Código Enviado!");

            }else{
                System.out.println("O endereço de e-mail "+ eml + " é inválido.");
                Dialog("Erro","Email Inválido.");
            }
        }
    }
}