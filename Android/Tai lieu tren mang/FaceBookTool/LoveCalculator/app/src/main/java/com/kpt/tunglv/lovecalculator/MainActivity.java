package com.kpt.tunglv.lovecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        Splash splash = new Splash();
//        fragmentTransaction.replace(R.id.fragment_place, splash);
//        fragmentTransaction.commit();
//        /****** Create Thread that will sleep for 3 seconds *************/
//        Thread background = new Thread() {
//            public void run() {
//
//                try {
//                    // Thread will sleep for 3 seconds
//                    sleep(3 * 1000);
//                    // After 3 seconds redirect to another intent
//                    Intent i = new Intent(getBaseContext(), Login.class);
//                    startActivity(i);
//                    //Remove activity
//                    finish();
//
//                } catch (Exception e) {
//
//                }
//            }
//        };
//
//        // start thread
//        background.start();

    }
}
