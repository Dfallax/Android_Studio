package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.Database.DatabaseAux;

public class DeleteToDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_to_db);
    }

    public void deleteValues(View v){
        //buscamos los resultados que tenagn el id del campo llamado showName y showEmail
        TextView nameTextView = findViewById(R.id.DeleteName);
        TextView emailTextView = findViewById(R.id.DeleteEmail);

        String nameString = nameTextView.getText().toString();
        String emailString = emailTextView.getText().toString();

//creamos una objeto
        DatabaseAux aux = new DatabaseAux(DeleteToDB.this);
        SQLiteDatabase db = aux.getWritableDatabase();

        if(db == null ){

            Toast.makeText(this, "No hay datos ", Toast.LENGTH_SHORT).show();
        }else{
                /* 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵🥵🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵
                 🥵🥵🥵🥵🥵🥵🥵🥵🥵
               */


            long del = db.delete("users", "name = '" + nameString+"' and email= '"+emailString+"'", null);

            if(del>0){
                Toast.makeText(this, "Todo OK", Toast.LENGTH_SHORT).show();
                nameTextView.setText("");
                emailTextView.setText("");
            }else{
                Toast.makeText(this, "Todo MAL", Toast.LENGTH_SHORT).show();
            }
            db.close();

        }

    }


}