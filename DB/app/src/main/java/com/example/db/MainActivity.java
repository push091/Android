package com.example.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonDel, buttonClear, buttonShow, buttonAdd; EditText ET_name, ET_phone;
    TextView text;
    DatabaseHelper DatabaseHelper; @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);
        buttonShow = findViewById(R.id.buttonShow);
        buttonShow.setOnClickListener(this);
        buttonDel = findViewById(R.id.buttonDel);
        buttonDel.setOnClickListener(this);
        buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(this);
        ET_name = findViewById(R.id.ET_name);
        ET_phone = findViewById(R.id.ET_phone);

        text = findViewById(R.id.text);

        DatabaseHelper = new DatabaseHelper(this);
    }


    @Override
    public void onClick(View v) {
        String input_name = ET_name.getText().toString(); String input_phone = ET_phone.getText().toString();

        SQLiteDatabase db = DatabaseHelper.getWritableDatabase(); ContentValues values = new ContentValues();

        if (v.getId()==R.id.buttonShow){

            text.setText(""); String[] projection = {
                    DBContract.DBEntry.COLUMN_NAME_NAME, DBContract.DBEntry.COLUMN_NAME_PHONE
            };
            Cursor cursor = db.query(
                    DBContract.DBEntry.TABLE_NAME, projection,
                    null, null, null, null, null
            );
            int index_name = cursor.getColumnIndex(DBContract.DBEntry.COLUMN_NAME_NAME);
            int index_phone = cursor.getColumnIndex(DBContract.DBEntry.COLUMN_NAME_PHONE);
            while (cursor.moveToNext()) {
                String value_name = cursor.getString(index_name);
                String value_phone = cursor.getString(index_phone);
                text.append("\n" + value_name + " \n " +
                        value_phone + " \n ");
            }
            cursor.close();
        }
        if (v.getId()==R.id.buttonAdd){
            values.put(DBContract.DBEntry.COLUMN_NAME_NAME,input_name);
            values.put(DBContract.DBEntry.COLUMN_NAME_PHONE, input_phone);
            db.insert(DBContract.DBEntry.TABLE_NAME, null, values);
            buttonShow.callOnClick();
        }
        if (v.getId()==R.id.buttonDel){
            String selection = DBContract.DBEntry.COLUMN_NAME_NAME +"=?";
            String[] selectionArgs = {input_name};
            db.delete(DBContract.DBEntry.TABLE_NAME, selection,
                    selectionArgs);
            buttonShow.callOnClick();
        }

        if (v.getId()==R.id.buttonClear){

            db.delete(DBContract.DBEntry.TABLE_NAME, null, null);
            buttonShow.callOnClick();
        }


        DatabaseHelper.close();
    }
}

