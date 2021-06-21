package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bottomnavigation.devicesfragments.PICFragment;
import com.example.bottomnavigation.entidades.Practicasvo;
import com.example.bottomnavigation.fragments.DetallesPracticaFragment;
import com.example.bottomnavigation.fragments.DevicesFragment;
import com.example.bottomnavigation.fragments.ListaPracticasFragment;
import com.example.bottomnavigation.fragments.ResistenciaFragment;
import com.example.bottomnavigation.interfaces.IComunicaFragments;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements ListaPracticasFragment.OnFragmentInteractionListener,
        DetallesPracticaFragment.OnFragmentInteractionListener, DevicesFragment.OnFragmentInteractionListener,
ResistenciaFragment.OnFragmentInteractionListener, PICFragment.OnFragmentInteractionListener, IComunicaFragments, DevicesFragment.Comunicador {


    BottomNavigationView mbottomNavigationView;

    ListaPracticasFragment listaFragment;
    DetallesPracticaFragment detallesFragment;
    PICFragment picFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////////////////////////////////////////
        listaFragment = new ListaPracticasFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,listaFragment).commit();
///////////////////////////////////////////////////


        mbottomNavigationView = findViewById(R.id.bottom);

        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.menu_tuto){
                    showSelectedFragment(new ListaPracticasFragment());
                }
                if (menuItem.getItemId() == R.id.menu_res){
                    showSelectedFragment(new ResistenciaFragment());

                }
                if (menuItem.getItemId() == R.id.menu_device){
                    showSelectedFragment(new DevicesFragment());

                }
                return true;
            }
        });


    }

    public void enviarPractica(Practicasvo practica) {
            detallesFragment = new DetallesPracticaFragment();
            Bundle bundleEnvio = new Bundle();
            bundleEnvio.putSerializable("objeto",practica);
            detallesFragment.setArguments(bundleEnvio);
            //cargar el fragment en el Activity
            getSupportFragmentManager().beginTransaction().replace(R.id.container,detallesFragment).addToBackStack(null).commit();
        }


    private void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).
                commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void enviarS(String dispositivo) {
         if (dispositivo == "PIC18F4620"){
             Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();
             picFragment = new PICFragment();
             getSupportFragmentManager().beginTransaction().replace(R.id.container,picFragment).addToBackStack(null).commit();
         }
    }
}
