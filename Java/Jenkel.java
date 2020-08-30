package com.example.tugas_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Jenkel extends AppCompatActivity {

    Button btnpilih;
    RadioGroup rgNumber;
    Button btnkembali;

    public static int RESULT_CODE = 110;
    public static String SELECTED_JENKEL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenkel);

        btnpilih = findViewById(R.id.btnPilih);
        rgNumber = findViewById(R.id.rg_number);
        btnpilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnPilih) {
                    if (rgNumber.getCheckedRadioButtonId() != 0) {
                        String jenkel = "tidak ada";
                        switch (rgNumber.getCheckedRadioButtonId()) {
                            case R.id.rb_L:
                                jenkel = "Laki-laki";
                                break;
                            case R.id.rb_P:
                                jenkel = "Perempuan";
                                break;
                        }

                        Intent resultJenkel = new Intent();
                        resultJenkel.putExtra(SELECTED_JENKEL, jenkel);
                        setResult(RESULT_CODE, resultJenkel);
                        finish();
                    }
                }
            }
        });
        btnkembali = findViewById(R.id.btnKembali);
        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kmbl = new Intent(Jenkel.this, MainActivity.class);
                startActivity(kmbl);
            }
        });
     }
}
