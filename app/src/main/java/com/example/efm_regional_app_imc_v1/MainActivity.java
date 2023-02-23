package com.example.efm_regional_app_imc_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText poids , taille;
    Button btnOk;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poids = findViewById(R.id.edPd);
        taille = findViewById(R.id.edTaille);
        btnOk = findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this , "IMC = "+ calculerIMC() +" , Etat = " + etat(),Toast.LENGTH_LONG).show();
            }

        });

    }
    public double calculerIMC(){
        double pd = Double.parseDouble(poids.getText().toString());
        double ta = Double.parseDouble(taille.getText().toString());

        return (pd/(ta*ta));
    }
    public String etat(){
        String etat = "";
        if(calculerIMC()<18.5){etat = "Maigreur";}
        else if(calculerIMC()>=18.5 && calculerIMC()<25){etat = "Normale";}
        else if(calculerIMC()<40 && calculerIMC()>=25){etat = "Supoids";}
        else if(calculerIMC()>=40 ){etat = "Obésité";}

        return etat;
    }
}