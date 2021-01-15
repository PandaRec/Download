package com.example.download;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadTask extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();
        URL url =null;
        HttpURLConnection httpURLConnection = null;

        try {
            url = new URL(strings[0]);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String oneLine = bufferedReader.readLine();
            while(oneLine!=null){
                stringBuilder.append(oneLine);
                oneLine = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(httpURLConnection!=null)
                httpURLConnection.disconnect();

        }


        return stringBuilder.toString();
    }
}
