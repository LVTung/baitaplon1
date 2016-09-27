package com.kpt.tunglv.lovecalculator;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.kpt.tunglv.lovecalculator.Splash.Splash;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Splash splash = new Splash();
        fragmentTransaction.replace(R.id.fragment_place, splash).commit();


    }
//Get Anh va camera 2016/09/06 (neu su dung fragment thi can phai co
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.fragment_place);
        fragment.onActivityResult(requestCode, resultCode, data);
    }
}
