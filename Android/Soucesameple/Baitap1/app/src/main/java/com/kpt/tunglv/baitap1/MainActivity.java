package com.kpt.tunglv.baitap1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView rcvNews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvNews=(RecyclerView)findViewById(R.id.rcvNews);
        rcvNews.setLayoutManager(new LinearLayoutManager(this));
        List <line_news>line_newsbeanlist=new ArrayList<>();
        for (int i=1;i<100;i++){
            line_newsbeanlist.add(new line_news("Tieng anh","tieng anh hoc kho","https://14415-presscdn-0-52-pagely.netdna-ssl.com/wp-content/uploads/brandwatch/troll.jpg","Perter"));
        }
        rcvNewsAdapter rcvNewsAdapter=new rcvNewsAdapter(line_newsbeanlist);
        rcvNews.setAdapter(rcvNewsAdapter);

        rcvNews.addItemDecoration(new DividerItemDecoration(this, R.drawable.divider));
    }
}
