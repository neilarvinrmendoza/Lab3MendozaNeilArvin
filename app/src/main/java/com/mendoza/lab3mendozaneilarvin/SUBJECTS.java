package com.mendoza.lab3mendozaneilarvin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SUBJECTS extends AppCompatActivity {
    CheckBox[] myLabel = new CheckBox[8];
    String selCourses[] = new String[8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        setTitle("SUBJECTS TAKEN");
        myLabel[0] = findViewById(R.id.checkBox);
        myLabel[1] = findViewById(R.id.checkBox2);
        myLabel[2] = findViewById(R.id.checkBox3);
        myLabel[3] = findViewById(R.id.checkBox4);
        myLabel[4] = findViewById(R.id.checkBox5);
        myLabel[5] = findViewById(R.id.checkBox6);
        myLabel[6] = findViewById(R.id.checkBox7);
        myLabel[7] = findViewById(R.id.checkBox8);

        FileInputStream reader = null;
        String data="";
        try {
            reader = openFileInput("courses.txt");
            int token;
            while((token = reader.read()) != -1){
                data = data + (char)token;
            }
        } catch (FileNotFoundException e) {
            Log.d("error", "File not found");
        } catch (IOException e) {
            Log.d("error", "IO error");
        }

        selCourses = data.split(" ");

        for(int i=0; i<myLabel.length;i++){
            myLabel[i].setText(selCourses[i]);
        }
    }

    public void displayCourses(View v){
        String outString = "";
        for(int ctr=0;ctr<myLabel.length;ctr++){
            if(myLabel[ctr].isChecked()){
                outString = outString + " " + myLabel[ctr].getText().toString();
            }
        }
        Toast.makeText(this, outString, Toast.LENGTH_LONG).show();
    }


}
