package com.kpt.tunglv.baitap1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAgenda, btnActualites, btnMembres, btnAvantages, btnLeaderboard, btnMonCompte, btnDeconnexion;
    ImageView imvLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnAgenda = (Button) findViewById(R.id.btnAgenda);
        btnActualites = (Button) findViewById(R.id.btnActualites);
        btnMembres = (Button) findViewById(R.id.btnMembres);
        btnAvantages = (Button) findViewById(R.id.btnAvantages);
        btnLeaderboard = (Button) findViewById(R.id.btnLeaderboard);
        btnMonCompte = (Button) findViewById(R.id.btnMonCompte);
        btnDeconnexion = (Button) findViewById(R.id.btnDeconnexion);
        imvLogo = (ImageView) findViewById(R.id.imvLogo);
        imvLogo.setImageResource(R.drawable.icon_logo);

        btnAgenda.setOnClickListener(this);
        btnActualites.setOnClickListener(this);
        btnMembres.setOnClickListener(this);
        btnAvantages.setOnClickListener(this);
        btnLeaderboard.setOnClickListener(this);
        btnMonCompte.setOnClickListener(this);
        btnDeconnexion.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnActualites:
                goToNextScreenNews();
                break;
            case R.id.btnMembres:
                goToNextScreenMembres();
                break;
            case R.id.btnAvantages:
                goToNextScreenSales();
                break;
            case R.id.btnLeaderboard:
                goToNextScreen();
                break;
            case R.id.btnMonCompte:
                goToNextScreenProfile();
                break;
            case R.id.editText:
                goToNextScreenSearch();
                break;
        }
    }

    private void goToNextScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToNextScreenNews() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToNextScreenMembres() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToNextScreenSales() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToNextScreenSearch() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToNextScreenProfile() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
