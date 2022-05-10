package com.example.networking;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private RecyclerView recyclerView; //skapa variabel
    private RecyclerViewAdapter recyclerViewAdapter; //skapa variabel
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    //private final String JSON_FILE = "mountains.json";

    private final String TAG = "==>";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view); //deklarera
        recyclerViewAdapter = new RecyclerViewAdapter();    //skapa en ny reycyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //skapa hur recyclerviewn ska se ut här en ny linearlayout
        recyclerView.setAdapter(recyclerViewAdapter);

        //new JsonFile(this, this).execute(JSON_FILE);

        //ArrayList<Mountain> m; ????



        new JsonTask(this).execute(JSON_URL);
    }

    @Override
    public void onPostExecute(String json) {

        Log.d(TAG, json);

        Log.d(TAG,json);

        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountain>>() {}.getType();
        List<Mountain> listOfMountains = gson.fromJson(json, type); //hämta lista från gson
        recyclerViewAdapter.setItems(listOfMountains);  //hämta lista från Mountain
        recyclerViewAdapter.notifyDataSetChanged();     //uppdatera

        Log.d(TAG,"Number of element " + listOfMountains.size() );
        Log.d(TAG , "element 0 "+ listOfMountains.get(0).toString());

    }

}
