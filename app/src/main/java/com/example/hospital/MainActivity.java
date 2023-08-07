package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et,et2,et3;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
        et3 = findViewById(R.id.editText3);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper dbhelper = new DatabaseHelper(MainActivity.this);
                boolean res = dbhelper.insertData(et.getText().toString(), et2.getText().toString(), Integer.parseInt(et3.getText().toString()));
                if (res)
                    Toast.makeText(MainActivity.this, "Insert Success", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Insert Failed", Toast.LENGTH_LONG).show();

            }
        });
    }
}