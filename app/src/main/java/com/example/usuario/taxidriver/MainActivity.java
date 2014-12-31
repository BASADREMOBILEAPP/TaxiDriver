package com.example.usuario.taxidriver;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                if (!verificarConexion(MainActivity.this)) {
                    AlertDialog.Builder alerta1 = new AlertDialog.Builder(MainActivity.this);
                    alerta1.setTitle("Comprueba tu conexión a Internet.");
                    alerta1.setMessage("Activa tu Wi-Fi o tu Plan de Datos :)");
                    alerta1.setIcon(android.R.drawable.stat_sys_warning);
                    alerta1.create();
                    alerta1.show();
                    alerta1.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog, int which) {
                                    // Code
                                }
                            });
                }
                else {
                    Intent intento = new Intent(MainActivity.this, Layout_registro.class);
                    startActivity(intento);
                }

            }
        });
    }

    public void lanzarInicioSesion(View view){
            Intent i = new Intent(this,Layout_entrar.class);
            startActivity(i);
    }


    public static boolean verificarConexion(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // No sólo wifi, también GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle debería no ser tan ñapa
        for (int i = 0; i < 2; i++) {
            // ¿Tenemos conexión? ponemos a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
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
