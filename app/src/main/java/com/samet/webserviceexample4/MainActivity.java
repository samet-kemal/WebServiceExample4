package com.samet.webserviceexample4;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import Adapter.InfoItemAdapter;
import Model.InfoItem;
import RestAPI.RestApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    InfoItemAdapter adapter;
    List<InfoItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
        Request();
    }


    public void Init() {
        listView = (ListView) findViewById(R.id.listView);
    }


    public void Request() {

        list = new ArrayList<>();

        Call<List<InfoItem>> call = RestApiClient.getInstance().getMyApi().getInfoList();
        call.enqueue(new Callback<List<InfoItem>>() {
            @Override
            public void onResponse(Call<List<InfoItem>> call, Response<List<InfoItem>> response) {
                if (response.isSuccessful()) {

                    list = response.body();
                    adapter = new InfoItemAdapter(list, getApplicationContext(),MainActivity.this);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<InfoItem>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Application FAILED When Data Come",Toast.LENGTH_LONG).show();
                Log.i(TAG, "onFail: " + t.toString());
            }
        });
    }


}