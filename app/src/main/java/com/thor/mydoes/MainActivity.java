package com.thor.mydoes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseReference  reference;
    RecyclerView ourdoes;
    ArrayList<MyDoes> list;
    DoesAdapter doesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //working with data
        ourdoes = findViewById(R.id.our_does);
        ourdoes.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<MyDoes>();

        //get data from firebase
        reference = FirebaseDatabase.getInstance().getReference().child("MyDoesApp");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //set data to retrive data and replace layout
                for (DataSnapshot dataSnapshot1: snapshot.getChildren()){
                    MyDoes p = dataSnapshot1.getValue(MyDoes.class);
                    list.add(p);
                }
                doesAdapter = new DoesAdapter(MainActivity.this, list);
                ourdoes.setAdapter(doesAdapter);
                doesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //set code to show an error
                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();

            }
        });
    }
}