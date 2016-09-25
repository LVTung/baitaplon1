package com.kpt.tunglv.lovecalculator;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kpt.tunglv.lovecalculator.Splash.Splash;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Splash splash = new Splash();
        fragmentTransaction.replace(R.id.fragment_place, splash).commit();


    }
}
