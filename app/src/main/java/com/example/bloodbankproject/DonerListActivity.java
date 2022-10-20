package com.example.bloodbankproject;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
public class DonerListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doner_list);
        String bloodgrp = getIntent().getStringExtra("bloodgrp");
        String city = getIntent().getStringExtra("city");
        String phone = getIntent().getStringExtra("phone");
        ArrayList<DonerData> data = dbHelper.getDonerList(this, bloodgrp, city, phone);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        for (DonerData d:data)
        {
            ListItem listitem = new ListItem();
            Bundle b = new Bundle();
            b.putInt("Id",d.id);
            b.putString("Name",d.full_name);
            b.putString("City",d.city);
            b.putString("Area",d.area);
            b.putString("Phone",d.phone);
            listitem.setArguments(b);
            fragmentTransaction.add(R.id.ListHolder,listitem);
        }
        fragmentTransaction.commit();
    }
}