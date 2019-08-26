package com.example.agilegroupfrontend;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import adapter.MainActivityAdapter;
import fragments.LogInFragment;
import fragments.SignUpFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sensorGyro();
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabId);

        MainActivityAdapter adapter = new MainActivityAdapter(getSupportFragmentManager());

        adapter.addFragment(new LogInFragment(),"LogIn");
        adapter.addFragment(new SignUpFragment(),"SignUp");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
//    private void sensorGyro() {
//
//        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
//        SensorEventListener gyrolistner = new SensorEventListener() {
//            @Override
//            public void onSensorChanged(SensorEvent event) {
//                if (event.values[1] < 0) {
//                    Toast.makeText(MainActivity.this, "You have turned left", Toast.LENGTH_SHORT).show();
//                }else if (event.values[1] > 0){
//                    Toast.makeText(MainActivity.this, "You have turned right", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//            }
//        };
//        if (sensor !=null){
//            sensorManager.registerListener(gyrolistner, sensor, SensorManager.SENSOR_DELAY_NORMAL);
//        }else {
//            Toast.makeText(MainActivity.this, "No sensor found", Toast.LENGTH_SHORT).show();
//        }
//    }
}
