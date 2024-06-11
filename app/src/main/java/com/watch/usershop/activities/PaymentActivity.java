package com.watch.usershop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import com.watch.usershop.R;
import com.watch.usershop.databinding.ActivityPaymentBinding;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    ActivityPaymentBinding binding;
    ProgressDialog CODp;

    double total;
    String orderCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        orderCode = getIntent().getStringExtra("orderCode");
        total = getIntent().getDoubleExtra("total", 1);

        binding.COD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processCOD();
            }
        });

        binding.bkash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processbkash();
            }
        });

        binding.nagad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processnagad();
            }
        });

        binding.rocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processrocket();
            }
        });

        binding.order.setText("Your Order Number is: " + orderCode);

        getSupportActionBar().setTitle("Payment Method");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    void processCOD(){
        new AlertDialog.Builder(this)
                .setTitle("Cash on Delivery")
                .setCancelable(false)
                .setMessage("Your products will be shipped within 24 hours. " +
                        "You can pay Rp " + total + " to the courier when you recieve the products at your doorstep.")
                .setPositiveButton("Confirm Order", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(PaymentActivity.this,HomeActivity.class);
                        Toast.makeText(PaymentActivity.this, "Order Confirmed", Toast.LENGTH_SHORT).show();
                        intent.putExtra("check","placed");
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .show();
    }
    void processbkash(){
        new AlertDialog.Builder(this)
                .setTitle("Gopay")
                .setCancelable(false)
                .setMessage("Place your payment of Rp " + total + " through Gopay to 081292786453. " +
                        "If you do not pay within 24 hours, your order will be cancelled.")
                .setPositiveButton("Confirm Order", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(PaymentActivity.this,HomeActivity.class);
                        Toast.makeText(PaymentActivity.this, "Order Confirmed", Toast.LENGTH_SHORT).show();
                        intent.putExtra("check","placed");
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).
                show();
    }
    void processnagad(){
        new AlertDialog.Builder(this)
                .setTitle("Dana")
                .setCancelable(false)
                .setMessage("Place your payment of Rp " + total + " through Dana to 081292786453. " +
                        "If you do not pay within 24 hours, your order will be cancelled.")
                .setPositiveButton("Confirm Order", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(PaymentActivity.this,HomeActivity.class);
                        Toast.makeText(PaymentActivity.this, "Order Confirmed", Toast.LENGTH_SHORT).show();
                        intent.putExtra("check","placed");
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .show();
    }
    void processrocket(){
        new AlertDialog.Builder(this)
                .setTitle("Ovo")
                .setCancelable(false)
                .setMessage("Place your payment of Rp " + total + " through Ovo to 081292786453. " +
                        "If you do not pay within 24 hours, your order will be cancelled.")
                .setPositiveButton("Confirm Order", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(PaymentActivity.this,HomeActivity.class);
                        Toast.makeText(PaymentActivity.this, "Order Confirmed", Toast.LENGTH_SHORT).show();
                        intent.putExtra("check","placed");
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).
                show();
    }

    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}