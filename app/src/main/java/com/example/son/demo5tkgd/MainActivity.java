package com.example.son.demo5tkgd;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnShowToast;
    Button btnShowAlertDialog;
    Button btnShowProgressDialog;
    Button btnShowDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowToast = findViewById(R.id.btnShowToast);
        btnShowAlertDialog = findViewById(R.id.btnShowAlertDialog);
        btnShowProgressDialog = findViewById(R.id.btnShowProgressDialog);
        btnShowDatePicker = findViewById(R.id.btnShowDatePicker);

        btnShowDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override



            public void onClick(View view) {

                final Calendar calendar = Calendar.getInstance();

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        int i3=i1+1;
                        Toast.makeText(MainActivity.this, ""+i+":"+i3+":"+i2, Toast.LENGTH_SHORT).show();
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }

        });


        showToast();
        showAlert();
        showProgress();
    }

    public void showProgress() {
        btnShowProgressDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                //

                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                } else {
                    progressDialog.show();
                }
            }
        });
        showAlert();
    }

    public void showAlert() {
        btnShowAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Alert");
                builder.setMessage("Hello con cho thai");
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                View view1 = inflater.inflate(R.layout.my_dialog, null);
                builder.setView(view1);
                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Ban vua bam ok", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Ban vua bam cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }

    public void showToast() {
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast
                Toast.makeText(MainActivity.this, "Noi dung muon hien thi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
