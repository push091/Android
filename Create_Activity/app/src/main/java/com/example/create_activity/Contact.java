package com.example.create_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        loadContacts();
    }

    private void loadContacts(){
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        ArrayList<String> contacts = new ArrayList<String>();

        if(cursor!=null){
            while (cursor.moveToNext()) {

                // получаем каждый контакт
                String contact = cursor.getString(
                        cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
                // добавляем контакт в список
                contacts.add(contact);
            }
            cursor.close();
        }

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, contacts);

        ListфView contactList = findViewById(R.id.contactList);
        // устанавливаем для списка адаптер
        contactList.setAdapter(adapter);
    }
}