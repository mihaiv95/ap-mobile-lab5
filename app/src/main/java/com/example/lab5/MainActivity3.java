package com.example.lab5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        b1 = (Button) findViewById(R.id.buton1);
//conecteaza obiectul b1 in lista de evenimente de tip click
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.buton2);
        b2.setOnClickListener(this);
    }
    public void onClick(View v) {
        Intent i = null;
        if (v.getId() == R.id.buton1) {
            i = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("http://www.google.ro"));
        }
//tipul de itents este dat de atributul ”http:”
        else if (v.getId() == R.id.buton2) {
            i = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("tel:07612421.."));
        }
//tipul de intents este dat de atributul ”tel:”
//porneste activitatea si transmite intents prin argumentul sau.
//Activitatea este identificata prin atributul din cadrul URI
        startActivity(i);
    }
}