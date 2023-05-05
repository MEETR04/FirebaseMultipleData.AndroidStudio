package com.example.firebasemultipledata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText roll, name, course, duration;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        roll = findViewById(R.id.roll);
        name = findViewById(R.id.name);
        course = findViewById(R.id.course);
        duration = findViewById(R.id.duration);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollno = roll.getText().toString();
                String sname = name.getText().toString();
                String scourse = course.getText().toString();
                String sduration = duration.getText().toString();


                DbHolder db = new DbHolder(sname,scourse,sduration);


                FirebaseDatabase mydb = FirebaseDatabase.getInstance();
                DatabaseReference reference = mydb.getReference("students");

                reference.child(rollno).setValue(db);

                Toast.makeText(getApplicationContext(), "Data inserted", Toast.LENGTH_SHORT).show();
                roll.setText("");
                name.setText("");
                course.setText("");
                duration.setText("");
            }
        });

    }
}