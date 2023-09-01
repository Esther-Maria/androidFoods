package com.example.foods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.widget.TextView;


import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {
    private Button btLogin;
    private EditText emailEdit, senhaEdit;
    private TextView esqueciSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLogin = findViewById(R.id.btnLogin);
        emailEdit = findViewById(R.id.emailEditText);
        senhaEdit = findViewById(R.id.passwordEditText);
        esqueciSenha = findViewById(R.id.forgotPasswordTextView);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean retorno = ValidarLogin();
                if(retorno  == true) {
                    Intent i = new Intent(MainActivity.this, Autenticado.class);
                    i.putExtra("nome_apelido", emailEdit.getText().toString());
                    startActivity(i);
                }
            }
        });

        esqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, EsqueciSenha.class);
                startActivity(i);
            }
        });

    }
    private boolean verificado() {
        boolean retorno = true;
        if (emailEdit.getText().toString().length() == 0) {
            emailEdit.setError("Digite um email.");
            retorno = false;
        }
        if (senhaEdit.getText().toString().length() == 0) {
            senhaEdit.setError("Digite a senha.");
            retorno = false;
        }
        return retorno;

    }

    private boolean ValidarLogin(){
        String email = emailEdit.getText().toString();
        String senha = senhaEdit.getText().toString();
        boolean retorno = false;
        Matcher matcher = Patterns.EMAIL_ADDRESS.matcher(email);

        if (verificado()){
            if (matcher.matches()) {
                System.out.println("O endereço de e-mail "+ email + " é válido.");
                System.out.println("A senha: " + senha);
                retorno = true;

            }else{
                System.out.println("O endereço de e-mail "+ email + " é inválido.");
                System.out.println("A senha: " + senha);
                Dialog("Autenticação Falhou","Usuario ou Senha Inválida.");
                retorno = false;
            }
        }
        return retorno;
    }
    private void Dialog(String Titulo,String Mensagem){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(Titulo)
                .setMessage(Mensagem)
                .show();
    }
}