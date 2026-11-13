package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    String key_email = "email";
    String key_haslo = "haslo";
    String preferencje = "preferencje";

    ArrayList<String> lista = new ArrayList<>();
    String email;
    String haslo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn_wroc = findViewById(R.id.btn_wroc);
        SharedPreferences settings = getSharedPreferences(preferencje, Context.MODE_PRIVATE);

        email = settings.getString(key_email, email);
        haslo1 = settings.getString(key_haslo, haslo1);

        lista.add("Zapisany e-mail: " + email);
        lista.add("Zapisane hasło: " + haslo1);

        ListView listaView = findViewById(R.id.listaView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);
        listaView.setAdapter(adapter);

        btn_wroc.setOnClickListener(v->{
            Intent intencja = new Intent(this, MainActivity.class);
            startActivity(intencja);
        });
    }

}