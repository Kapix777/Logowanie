package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String key_email = "email";
    String key_haslo = "haslo";
    String preferencje = "preferencje";
    String email;
    String haslo1;
    String haslo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView wys = findViewById(R.id.wys);
        Button btn_zatwierdz = findViewById(R.id.btn_zatwierdz);
        Button btn_zapisz = findViewById(R.id.btn_zapisz);

        SharedPreferences settings = getSharedPreferences(preferencje, Context.MODE_PRIVATE);

        EditText Editemail = findViewById(R.id.email);
        EditText Edithaslo1 = findViewById(R.id.haslo1);
        EditText Edithaslo2 = findViewById(R.id.haslo2);



        /*
         *Obsługuje zdarzenie kliknięcia przycisku "ZATWIERDŹ".
         * Sprawdza poprawność danych
         *
         * @param btn_zatwierdz reprezentujący kliknięty przycisk.
         * @author Kacper Węgrzynowicz
        */

        btn_zatwierdz.setOnClickListener(v->{
            email = Editemail.getText().toString();
            haslo1 = Edithaslo1.getText().toString();
            haslo2 = Edithaslo2.getText().toString();

            if (!haslo1.equals(haslo2)){
                wys.setText("Hasła się różnią");
            } else if (!email.contains("@")) {
                wys.setText("Nieprawidłowy adres e-mail");
            } else{
                wys.setText("Witaj " + email);
                Intent intencja = new Intent(this, MainActivity2.class);
                startActivity(intencja);
            }
        });
        btn_zapisz.setOnClickListener(v->{
            email = Editemail.getText().toString();
            haslo1 = Edithaslo1.getText().toString();
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(key_email, email);
            editor.putString(key_haslo, haslo1);
            editor.apply();
        });

    }
}