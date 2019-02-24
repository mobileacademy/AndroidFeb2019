package com.example.lesson2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity {

    private RecyclerView list;
    private ArrayList<Student> dataSource;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        list = findViewById(R.id.recycleView);
        dataSource = new ArrayList<>();
        for (int i=0; i< 100; i++) {
            Student student = new Student("Name" + String.valueOf(i), R.drawable.ic_menu_share);
            dataSource.add(student);
        }

        adapter = new StudentAdapter(dataSource);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.scrollToPosition(0);

        list.setLayoutManager(layoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        list.addItemDecoration(itemDecoration);


        list.setAdapter(adapter);
    }
}
