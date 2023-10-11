package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.DataBase.DataBaseAux;

public class Show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
    }
    public void changeToMain(View view) {
        Intent nIntent = new Intent(Show.this, MainActivity.class);
        startActivity(nIntent);
    }
    void ShowElements(){
        SQLiteDatabase db = new DataBaseAux(this).getReadableDatabase();

        Cursor cursor  = db.rawQuery("SELECT * FROM users", null);

        if(cursor.moveToFirst()){
            TextView showNameView = findViewById(R.id.showNameView);
            TextView showEmailView = findViewById(R.id.showEmailView);
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String email = cursor.getString(2);

                showNameView.setText(id + " " + name);
                showEmailView.setText(email);

            }while(cursor.moveToNext());
            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

}