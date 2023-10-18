package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.test.Database.DatabaseAux;

public class Show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        showElements();
    }

    public void changeToMain(View view) {
        Intent nIntent = new Intent(Show.this, MainActivity.class);
        startActivity(nIntent);
    }

    void showElements() {
        SQLiteDatabase db = new DatabaseAux(this).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM users", null);
        //TextView showNameView = findViewById(R.id.showName);
        //TextView showEmailView = findViewById(R.id.showEmail);

        LinearLayout layout = findViewById(R.id.ContentShow);


        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);//sacamos las posiciones de la base de datos
                String name = cursor.getString(1);
                String email = cursor.getString(2);

                TextView data = new TextView(this);
                data.setText("Nombre: "+ name +" Email: "+ email);//ingreamos datos al objeto data
                layout.addView(data);// acá le añadimos al layou para que se muestre los resultados
                //showNameView.setText(id + " " + name);
               // showEmailView.setText(email);
            }while(cursor.moveToNext());
        }

        db.close();
    }
}