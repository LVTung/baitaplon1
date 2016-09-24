package com.kpt.tunglv.lovecalculator;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.kpt.tunglv.lovecalculator.Login.Login;
import com.kpt.tunglv.lovecalculator.Splash.Splash;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Splash splash = new Splash();
        fragmentTransaction.replace(R.id.fragment_place, splash);
        fragmentTransaction.commit();

    }
}
