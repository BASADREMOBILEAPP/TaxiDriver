package com.example.usuario.taxidriver;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Layout_registro extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registro);

        Parse.initialize(this, "Lackvxrwz7K5sQtxagm8LSoTPsqtWDWMoOYoAYzA", "38iRP2FhSPcwHNmoLVaVRD6XLEtBX18dYibtygzJ");
        ParseAnalytics.trackAppOpened(getIntent());

        // bueno ya saben para q sirve lo de abajo
        Button guardar_usuario = (Button)findViewById(R.id.btn_regis);
        guardar_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario =((EditText)findViewById(R.id.edit_usuario1)).getText().toString();
                String contra =((EditText)findViewById(R.id.edit_contra1)).getText().toString();
                String email =((EditText)findViewById(R.id.edit_email1)).getText().toString();

                // Esta es la parte en la que mandamos el registro a parse, esto se puede ver en la guia, las 3 primeras lineas son de una clase special q se llama user
                // esta configurada para hacer la gestion de usuarios   sadasdas
                ParseUser user = new ParseUser();
                user.setUsername(usuario);
                user.setPassword(contra);
                user.setEmail(email);

                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            // Hooray! Let them use the app now.
                            Toast.makeText(getApplicationContext(), "Usuario Registrado", Toast.LENGTH_SHORT).show();
                        } else {
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                            Toast.makeText(getApplicationContext(),"Usuario No Registrado",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
