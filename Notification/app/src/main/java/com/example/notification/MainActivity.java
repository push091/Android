package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFY_ID = 101;
    private static String CHANNEL_ID = "Channel 101";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toast= findViewById(R.id.toast_Button);
        Button push= findViewById(R.id.push_Button);
        Button exit= findViewById(R.id.exit_Button);



        toast.setOnClickListener(this::toas_make);
        push.setOnClickListener(this::PUSH);
        exit.setOnClickListener(this::Exit);

    }

    private void Exit(View view) {

        FragmentManager manager= getSupportFragmentManager();
        MyDialogFragment myDialogFragment= new MyDialogFragment();
        myDialogFragment.show(manager,"myDialog");

    }

    private void PUSH(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("Уведомление!")
                        .setContentText("Безыдейный текст")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);
        notificationManager.notify(NOTIFY_ID, builder.build());


    }

    private void toas_make(View view) {

        LayoutInflater inflater= getLayoutInflater();
        View layout =inflater.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.custom_toast_container));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}