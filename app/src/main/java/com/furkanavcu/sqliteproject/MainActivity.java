package com.furkanavcu.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {

            SQLiteDatabase database = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY, name VARCHAR, age INTEGER)");
            //EKLEME
            /*database.execSQL("INSERT INTO musicians(name, age) VALUES ('Ogün Sanlısoy',48)");*/

            //GÜNCELLEME
            //database.execSQL("UPDATE musicians SET age=49 WHERE name='Ogün Sanlısoy'");

            //SİLME
            //database.execSQL("DELETE FROM musicians WHERE id=2");

            //ÖZEL FİLTRELELEME DURUMU uuu yes
            //Cursor cursor=database.rawQuery("SELECT*FROM musicians WHERE name LIKE '%s'",null);


            //ARAMA
            Cursor cursor = database.rawQuery("SELECT * FROM musicians", null);


            int nameIndex = cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");
            int idIndex= cursor.getColumnIndex("id");

            while (cursor.moveToNext()) {
                System.out.println("Name: " + cursor.getString(nameIndex));
                System.out.println("Age: " + cursor.getInt(ageIndex));
                System.out.println("İd: "+cursor.getInt(idIndex));
            }

            cursor.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}