package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.DataBase.DataBaseAux;

public class InsertToDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_to_db);
    }
    public void ChangeToMain (View view){

Intent nuevoIntent = new Intent (InsertToDB.this, MainActivity.class);
   // startActivity(Intent);
    }
    public void insertValues (View v){

        TextView nameTextView = findViewById(R.id.insertName);
        TextView emailTextView = findViewById(R.id.insertEmail);

        String nameString = nameTextView.getText().toString();
        String emailString = emailTextView.getText().toString();

        DataBaseAux aux = new DataBaseAux(InsertToDB.this);
        SQLiteDatabase db = aux.getReadableDatabase();

        if(db != null && !nameString.isEmpty() && !emailString.isEmpty()){
            ContentValues values = new ContentValues();
            values.put("name",nameString);
            values.put("email",emailString);

           long res = db.insert("users",null,values);
        if(res >=0){
            Toast.makeText(this, "Insertado correctamente", Toast.LENGTH_LONG).show();
            nameTextView.setText("");
            emailTextView.setText("");
        }else{
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
        }
        }

        ContentValues values = new ContentValues();
        values.put("name",nameString);
        values.put("email",emailString);


    }
    public void changeToShow(View view) {
        Intent nIntent = new Intent(InsertToDB.this, Show.class);
        startActivity(nIntent);
    }

}