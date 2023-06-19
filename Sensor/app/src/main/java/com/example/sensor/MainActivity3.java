package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor mLight;
    TextView myText,Massage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    Massage=findViewById(R.id.massageView);
    myText=findViewById(R.id.text1);

    sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);


    if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT )!= null){
        Massage.append("На устройстве есть датчик освещенности \n");
    }else {
        Massage.append("На устройстве нет датчика освещенности \n");
    }

}
    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
// Действия, если точность изменилась
    }
    @Override
    public final void onSensorChanged(SensorEvent event) {
        float lux = event.values[0];
        myText.append(Float.toString(lux)+"\n");
    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause(); sensorManager.unregisterListener(this);
    }

}