package com.example.tugas_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Menu extends AppCompatActivity implements View.OnClickListener {

    Button btnjenkel;
    Button btnkembali;
    TextView tvjenkel;
    TextView txtnama;

    public static int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        txtnama = (TextView) findViewById(R.id.txtView);
        Bundle bundle = getIntent().getExtras();
        String s = bundle.getString("nama");
        txtnama.setText(s);

        btnjenkel = findViewById(R.id.btnJenkel);
        btnjenkel.setOnClickListener(this);

        btnkembali = findViewById(R.id.btnKembali);
        btnkembali.setOnClickListener(this);

        tvjenkel = findViewById(R.id.txtJenkel);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnJenkel :
                Intent jenkel = new Intent(Menu.this, Jenkel.class);
                startActivityForResult(jenkel, REQUEST_CODE);
                break;

            case R.id.btnKembali :
                Intent kmbl = new Intent(Menu.this, MainActivity.class);
                startActivity(kmbl);
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Jenkel.RESULT_CODE) {
                String pilJenkel = data.getStringExtra(Jenkel.SELECTED_JENKEL);
                tvjenkel.setText(String.format("Jenis kelamin anda adalah " + pilJenkel));
            }
        }
    }
}