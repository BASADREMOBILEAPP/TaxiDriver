package com.example.usuario.taxidriver;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.FrameLayout;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.parse.Parse;
import com.parse.ParsePush;


public class search_map extends ActionBarActivity {

    //Añadiendo nuevo mapa de Google Maps
    GoogleMap map;

    //Latitud y altitud obtenidas
    double latitude;
    double longitude;
    Location location=null;

    //API KEY
    String APPLICATION_ID = "Lackvxrwz7K5sQtxagm8LSoTPsqtWDWMoOYoAYzA";
    String CLIENT_KEY = "38iRP2FhSPcwHNmoLVaVRD6XLEtBX18dYibtygzJ";

    //Views
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_map);
        Parse.initialize(this,APPLICATION_ID,CLIENT_KEY);

        getGoogleMap();

        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMyLocation(location);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_map, menu);
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
            Intent intent = new Intent(getApplicationContext(),Preferencias.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getGoogleMap(){
        try{
            if(map==null)
                map =((MapFragment) getFragmentManager().findFragmentById(R.id.mapView)).getMap(); //Mostrar mapa nuevo
                map.setMyLocationEnabled(true); //Muestra la localizacion actual
                map.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() { //Detecta cambios de posicion y lo muestra
                    @Override
                    public void onMyLocationChange(Location _location) {
                        location = _location; //Localizacion actualizada
                    }
                });
        }
        catch (Exception e)
        {

        }
    }

    public void sendMyLocation(Location location){
        ParsePush push = new ParsePush();

        if(location!=null) {
            //Obteninedo longitud y latitud de location
            latitude = location.getLatitude();
            longitude = location.getLongitude();

            //Asignando y mandando un mensaje al canal
            push.setChannel("Taxis");
            push.setMessage("hola a todos " + Double.toString(latitude));
            push.sendInBackground();
        }
        else
            Toast.makeText(getApplicationContext(),"Obteniendo ubicacion ...",Toast.LENGTH_LONG).show();
    }

}
