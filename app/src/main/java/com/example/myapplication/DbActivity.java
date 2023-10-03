package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class DbActivity extends AppCompatActivity {

    DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        helper = new DatabaseHelper(this);

        //SQLiteDatabase sqlite = helper.getWritableDatabase();
        //ContentValues cv = new ContentValues();
        //cv.put("modelo","gol bolinha");
        //cv.put("ano","2001");
        //cv.put("valor","R$ 10.000,00");
        //long res = sqlite.insert("carros", null, cv);
        //Toast.makeText(this, res + "", Toast.LENGTH_SHORT).show();

        SQLiteDatabase sqlite = helper.getReadableDatabase();
        Cursor cursor = sqlite.rawQuery("SELECT * FROM CARROS", null);
        cursor.moveToFirst();
        String str = "";
        for(int i=0; i < cursor.getCount(); i++){
            str += cursor.getString(0)+ "\t";
            str += cursor.getString(1) + "\t";
            str += cursor.getString(2)+ "\t";
            str += cursor.getString(3) + "\n";
            cursor.moveToNext();
        }
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
}