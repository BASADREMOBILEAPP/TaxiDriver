package com.example.usuario.taxidriver;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class Choferes_caracteristicas extends ActionBarActivity {

    ListViewAdapter adapter;

    String[] titulo = new String[]{
            "   Alvaro Morales  40 años",
            "   Edwin Limachi  45 años",
            "   Julio Villaca  50 años",
            "   Uriel Villaca  34 años",
            "   Angel Medina  23 años",
    };

    int[] imagenes = {
            R.drawable.taxista1,
            R.drawable.taxista2,
            R.drawable.taxista1,
            R.drawable.taxista2,
            R.drawable.taxista5
    };
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choferes_caracteristicas);
        final ListView lista = (ListView)  findViewById(R.id.listView1);
        adapter =new ListViewAdapter(this,titulo, imagenes);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(), "conductor  " +i,Toast.LENGTH_SHORT).show();
            }

        });
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"AKLRTP"+i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choferes_caracteristicas, menu);
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
}
