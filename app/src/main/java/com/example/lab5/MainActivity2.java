package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    final private static int COD_RASPUNS_02 = 1234; // se recomanda definirea intr-un fisier de resurse pentru a pastra unicitatea
    Button b1; //b1 obiectul buton
    EditText e1; // e1 obiectul cutie de editare

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);//asigneaza fisierul XML cu fereastra construita in Java
        TextView t1r = (TextView) findViewById(R.id.T1R);//instantiere clasa pentru afisare text (needitabila)
        e1 = (EditText) findViewById(R.id.E1_Raspuns);//instantiere clasa ptr. cutia de editare
        Bundle dateDinBundle = getIntent().getExtras();// obtine datele din obiectul transmis prin argument
        if (dateDinBundle != null) {//daca au fost transmise date
            String atrib1 = dateDinBundle.getString("atribut_01"); //obtine valorile atasate atributului atribut_01 (pot fi mai multe atribute)
            Toast.makeText(getApplicationContext(), "Mesaj:" + atrib1,
                    Toast.LENGTH_SHORT).show(); // afisare optionala mesaj pentru test
            t1r.setText(atrib1); // setare control text cu valoarea obtinuta
        }
        b1 = (Button) findViewById(R.id.B1_Raspunde); // asignare resurse control
        b1.setOnClickListener(this); // asignare metoda Click ptr. obiectul fereastra curenta
    }

    public void onClick(View v) { //redefinire metoda Click
        if (v.getId() == R.id.B1_Raspunde) { // in functie de controlul implicat
            Intent intentia_x = new Intent(); // creare intentie
            intentia_x.putExtra("atributRaspuns_01", e1.getText().toString()); //se poate
//adauga direct informatii intentiei - fara a utiliza un obiect de tip Bundle
            setResult(COD_RASPUNS_02, intentia_x); //asignare cod raspuns intentiei
            finish();// incheierea intentiei (DOAR in acest caz) si a activitatii
        }
    }
}