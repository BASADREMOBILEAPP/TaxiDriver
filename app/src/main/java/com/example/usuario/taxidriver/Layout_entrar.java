package com.example.usuario.taxidriver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

public class Layout_entrar  extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_entrar);

        // inicialisamos el parse desde esta clase identificando las llaves de id y de usuario: xd
        Parse.initialize(this, "Lackvxrwz7K5sQtxagm8LSoTPsqtWDWMoOYoAYzA", "38iRP2FhSPcwHNmoLVaVRD6XLEtBX18dYibtygzJ");
        ParseAnalytics.trackAppOpened(getIntent());
        ParseInstallation.getCurrentInstallation().saveInBackground();

        Button entrar = (Button)findViewById(R.id.btn_entrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usua = ((EditText)findViewById(R.id.edit_usuarioIn)).getText().toString();
                String contras =((EditText)findViewById(R.id.edit_contraIn)).getText().toString();

                ParseUser.logInInBackground(usua, contras, new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) { // Esto es, si el inicio de sesion es correcto
                            Intent i = new Intent(Layout_entrar.this,search_map.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(),"Usuario o Contraseña incorrecto(s)",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }



}
