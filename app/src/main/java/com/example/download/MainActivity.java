package com.example.download;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private  String url = "https://mail.ru";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("test","жопа");
        DownloadTask downloadTask = new DownloadTask();
        try {
            String rez = downloadTask.execute(url).get();
            Log.i("test",rez);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}