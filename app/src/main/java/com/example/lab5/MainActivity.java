package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final private static int COD_CERERE_02 = 123; //
    final private static int COD_RASPUNS_02 = 1234;
    Button b1; //b1 obiectul buton
    EditText e1; // e1 obiectul cutie de editare
    TextView t1; // obiectul text

    Button goTo;

    void afis(String sir) // functie pentru afisarea unui mesaj
    {
        Toast.makeText(getApplicationContext(), sir, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.E1); //instantiere clasa ptr. cutia de editare
        b1 = (Button) findViewById(R.id.B1_Trimite); //instantiere clasa ptr. buton
        t1 = (TextView) findViewById(R.id.T2_Receptionat); //instantiere clasa pentru afisare text (needitabila)
        b1.setOnClickListener(this); // asignare metoda Click ptr. obiectul fereastra curent
        goTo = (Button) findViewById(R.id.button);
        goTo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //utilizarea intenției
                Intent intent = new Intent(v.getContext(), MainActivity3.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    public void onClick(View v) { //redefinire metoda Click
        if (v.getId() == R.id.B1_Trimite) { // in functie de controlul implicat
            Intent intentia_01 = new Intent(this, MainActivity2.class); // creare intentie interna aplicatiei
            intentia_01.putExtra("atribut_01", e1.getText().toString()); // este aleasa o denumire de atribut careia
            // i se asociaza valoarea din cadrul cutiei de editare
            startActivityForResult(intentia_01, COD_CERERE_02); // este transmisa intentia intentia_01 si
            // i se asociaza un cod cu scopul citiri unui raspuns in urma lansarii acesteia
        }
    }

    @Override
    protected void onActivityResult(int codCerere, int codRezultat, Intent
            intentie_y) {
        //metoda interna redefinita
        super.onActivityResult(codCerere, codRezultat, intentie_y);
        if (codCerere == COD_CERERE_02) {
            if (codRezultat == COD_RASPUNS_02) {
                String raspuns = intentie_y.getStringExtra("atributRaspuns_01");
                //extrage valoarea asociata atributului atributRaspuns_01
                afis(raspuns);
                t1.setText(raspuns.toString()); // afiseaza textul
            }
        }
    }

}