package com.example.usuario.taxidriver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        // las llaves del proyecto en parse: llave de la acpliacion y del usuario
        Parse.initialize(this, "Lackvxrwz7K5sQtxagm8LSoTPsqtWDWMoOYoAYzA", "38iRP2FhSPcwHNmoLVaVRD6XLEtBX18dYibtygzJ");
        ParseAnalytics.trackAppOpened(getIntent());
        ParseInstallation.getCurrentInstallation().saveInBackground();


        Button btn_re = (Button)findViewById(R.id.btn_crearC);
        btn_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Layout_registro.class);
                startActivity(i);
            }
        });
    }

    public void lanzarInicioSesion(View view){
        Intent i = new Intent(this,Layout_entrar.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startMap(View view){
        Intent intent = new Intent(this,search_map.class);
        startActivity(intent);
    }
}
