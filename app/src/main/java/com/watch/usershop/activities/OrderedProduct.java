package com.watch.usershop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.watch.usershop.R;
import com.watch.usershop.adapters.CartAdapter;
import com.watch.usershop.databinding.ActivityCheckoutBinding;
import com.watch.usershop.databinding.ActivityOrderedProductBinding;
import com.watch.usershop.model.Product;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hishd.tinycart.model.Cart;
import com.hishd.tinycart.util.TinyCartHelper;

import java.util.ArrayList;

public class OrderedProduct extends AppCompatActivity {

    CartAdapter adapter;
    ArrayList<Product> products;
    Cart cart;
    ActivityOrderedProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderedProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ordered Products");
        FirebaseFirestore dbroot = FirebaseFirestore.getInstance();

        products = new ArrayList<>();

        cart = TinyCartHelper.getCart();
        int i=1;
        String str = "";

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        dbroot.collection("watchaholic").document(email+"orderedProduct")
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            String str_product = documentSnapshot.getString("Products");
                            binding.productOrder.setText(str_product);

                        }
                        else binding.productOrder.setText("Did not order any product yet!");
                    }
                });




    }

    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}