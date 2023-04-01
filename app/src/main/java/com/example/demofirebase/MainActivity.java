package com.example.demofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText rollEditText;
    private TextInputEditText nameEditText;
    private TextInputEditText courseEditText;
    private TextInputEditText cgpaEditText;
    private Button addToDatabaseBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollEditText=findViewById(R.id.rollEditText);
        nameEditText=findViewById(R.id.nameEditText);
        courseEditText=findViewById(R.id.courseEditText);
        cgpaEditText=findViewById(R.id.cgpaEditText);



        addToDatabaseBtn=findViewById(R.id.addToDatabaseBtn);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference node = db.getReference("Students");
        addToDatabaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Objects.requireNonNull(nameEditText.getText()).toString().equals("")) {
                    String roll=rollEditText.getText().toString().trim();
                    String name=nameEditText.getText().toString().trim();
                    String course=courseEditText.getText().toString().trim();
                    String cgpa=cgpaEditText.getText().toString().trim();
                    DataHolder dataHolder = new DataHolder(name,course,cgpa);
                    node.child(roll).setValue(dataHolder);

                    rollEditText.setText("");
                    nameEditText.setText("");
                    courseEditText.setText("");
                    cgpaEditText.setText("");

                    Toast.makeText(MainActivity.this, "Data  stored in the Firebase", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Enter your name", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}