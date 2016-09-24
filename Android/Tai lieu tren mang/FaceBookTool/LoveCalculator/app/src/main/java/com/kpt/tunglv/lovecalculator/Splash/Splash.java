package com.kpt.tunglv.lovecalculator.Splash;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kpt.tunglv.lovecalculator.Login.Login;
import com.kpt.tunglv.lovecalculator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Splash extends Fragment {


    public Splash() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /****** Create Thread that will sleep for 3 seconds *************/
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 3 seconds
                    sleep(3 * 1000);
                    // After 3 seconds redirect to another intent
                    android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Login login = new Login();
                    fragmentTransaction.replace(R.id.fragment_place, login);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    //Remove activity
                } catch (Exception e) {
                }
            }
        };

        // start thread
        background.start();

    }
}

