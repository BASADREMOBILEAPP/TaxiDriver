package com.example.usuario.taxidriver;

import android.location.Location;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.FrameLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.parse.Parse;


public class search_map extends ActionBarActivity {

    //Añadiendo nuevo mapa de Google Maps
    GoogleMap map;
    double latitude;
    double longitude;
    String APPLICATION_ID = "Lackvxrwz7K5sQtxagm8LSoTPsqtWDWMoOYoAYzA";
    String CLIENT_KEY = "38iRP2FhSPcwHNmoLVaVRD6XLEtBX18dYibtygzJ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_map);
        Parse.initialize(this,APPLICATION_ID,CLIENT_KEY);



        getGoogleMap();
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
                    public void onMyLocationChange(Location location) {
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                        Toast.makeText(search_map.this,
                                "Lat: " + latitude + "\nLon: " + longitude, Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        }
        catch (Exception e)
        {

        }
    }

    public void sendMyLocation(){

    }
}
