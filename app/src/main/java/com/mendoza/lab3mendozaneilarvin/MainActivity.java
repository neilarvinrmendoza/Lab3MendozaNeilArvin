package com.mendoza.lab3mendozaneilarvin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText course1, course2, course3, course4, course5, course6, course7, course8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        course1 = findViewById(R.id.editText);
        course2 = findViewById(R.id.editText2);
        course3 = findViewById(R.id.editText3);
        course4 = findViewById(R.id.editText4);
        course5 = findViewById(R.id.editText5);
        course6 = findViewById(R.id.editText6);
        course7 = findViewById(R.id.editText7);
        course8 = findViewById(R.id.editText8);
    }

    public void saveCourse(View v){
        String courseSP1 = course1.getText().toString() + " ";
        String courseSP2 = course2.getText().toString() + " ";
        String courseSP3 = course3.getText().toString() + " ";
        String courseSP4 = course4.getText().toString() + " ";
        String courseSP5 = course5.getText().toString() + " ";
        String courseSP6 = course6.getText().toString() + " ";
        String courseSP7 = course7.getText().toString() + " ";
        String courseSP8 = course8.getText().toString();
        FileOutputStream writer = null;
        try {
            writer = openFileOutput("courses.txt",MODE_PRIVATE);
            writer.write(courseSP1.getBytes());
            writer.write(courseSP2.getBytes());
            writer.write(courseSP3.getBytes());
            writer.write(courseSP4.getBytes());
            writer.write(courseSP5.getBytes());
            writer.write(courseSP6.getBytes());
            writer.write(courseSP7.getBytes());
            writer.write(courseSP8.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error", "File not found");
        } catch (IOException e) {
            Log.d("error", "IO error");
        }finally{
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "File not found");
            }
        }
        Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();
    }

    public void nextPage(View v){
        Intent i = new Intent(this, SUBJECTS.class);
        startActivity(i);
    }
}
