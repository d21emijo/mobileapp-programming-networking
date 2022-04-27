package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    //private final String JSON_FILE = "mountains.json";

    private final String TAG = "==>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new JsonFile(this, this).execute(JSON_FILE);
        new JsonTask(this).execute(JSON_URL);

    }

    @Override
    public void onPostExecute(String json) {

        Log.d(TAG, json);

        Log.d(TAG,json);

        Gson gson = new Gson();
        Type type = new TypeToken<List<com.example.readjsonfromfiledemo.Mountain>>() {}.getType();
        List<com.example.readjsonfromfiledemo.Mountain> listOfMountains = gson.fromJson(json, type);

        Log.d(TAG,"Number of element " + listOfMountains.size() );
        Log.d(TAG , "element 0 "+ listOfMountains.get(0).toString());

    }

}
