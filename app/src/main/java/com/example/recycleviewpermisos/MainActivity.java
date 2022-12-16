package com.example.recycleviewpermisos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import com.example.recycleviewpermisos.Adapter.PermisosAdapter;
import com.example.recycleviewpermisos.Model.Perrmisos;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<com.example.recycleviewpermisos.Model.Perrmisos> Perrmisos;
    Perrmisos item2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();
    }
    private void iniciar() {
        Perrmisos = new ArrayList<Perrmisos>();
        Perrmisos.add(new Perrmisos("Calendario",new String[]{Manifest.permission.READ_CALENDAR}));
        Perrmisos.add(new Perrmisos("Contactos",new String[]{Manifest.permission.READ_CONTACTS}));
        Perrmisos.add(new Perrmisos("Ubicacion",new String[]{Manifest.permission.ACCESS_BACKGROUND_LOCATION}));
        Perrmisos.add(new Perrmisos("Camara",new String[]{Manifest.permission.CAMERA}));
        Perrmisos.add(new Perrmisos("Galeria",new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}));

        PermisosAdapter listAdapter = new PermisosAdapter(Perrmisos, new PermisosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(com.example.recycleviewpermisos.Model.Perrmisos item) {
                pedirPermiso(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
    public void pedirPermiso(Perrmisos item)
    {
        if (ActivityCompat.checkSelfPermission(this, String.valueOf(item.getPermiso())) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, item.getPermiso(), 255);
        }else {
            evento();
        }
    }
    public void evento()
    {
        Intent cargarCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(cargarCamara);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==255){
            if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                evento();
            }
        }
    }
}