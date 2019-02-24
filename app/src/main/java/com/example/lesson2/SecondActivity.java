package com.example.lesson2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private Button myButton;
    private Switch wifiSwitch;
    private RadioGroup radioGroup;
    private ListView myList;
    private ArrayList<String> dataSource = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        myButton = findViewById(R.id.button);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra("count", 10);

                setResult(Activity.RESULT_OK, result);
                finish();
            }
        });

        wifiSwitch = findViewById(R.id.myswitch);
        Log.d("secondActivity", "switchState=" + wifiSwitch.isChecked());

        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(SecondActivity.this, "Wifi is On", Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroup = findViewById(R.id.myradiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String name = "";

                if (checkedId == R.id.radioBtn1) {
                    name = "RadioBtn1";
                } else {
                    name = "RadioBtn2";
                }

                Toast.makeText(SecondActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });

        myList = findViewById(R.id.myList);

        for (int i =0; i< 10000; i++) {
            dataSource.add("Item " + String.valueOf(i));
        }

        //ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataSource);

        MyCustomAdapter adapter = new MyCustomAdapter(this, dataSource);
        myList.setAdapter(adapter);



    }
}
