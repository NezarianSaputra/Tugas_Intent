package com.example.tugas_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    EditText nama;
    Button masuk;
    Button keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nama = (EditText) findViewById(R.id.editNama);
        masuk = findViewById(R.id.btnMasuk);
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent masuk = new Intent(MainActivity.this, Menu.class);
                masuk.putExtra("nama", nama.getText().toString());
                startActivity(masuk);
            }
        });

        keluar = findViewById(R.id.btnKeluar);
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder notifikasi = new AlertDialog.Builder(MainActivity.this);
                notifikasi.setTitle("Keluar");
                notifikasi.setMessage("Yakin ingin keluar ?");
                notifikasi.setPositiveButton("Ya, keluar sekarang !", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }
                });
                notifikasi.setNegativeButton("Tidak sekarang", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = notifikasi.create();
                dialog.show();
            }

        });
    }
}
