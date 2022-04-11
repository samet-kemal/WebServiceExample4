package com.samet.webserviceexample4;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import Model.ResultItem;
import RestAPI.RestApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoItemActivity extends AppCompatActivity {


    TextView postIdTextView,idTextView,nameTextView,emailTextView,bodyTextView;
    String id, postId;
    List<ResultItem> listResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_item);
        Init();
        getIntentValues();
    }


    public void getIntentValues() {
        Bundle bundle = getIntent().getExtras();
        postId = bundle.getString("postId");
        id = bundle.getString("id");
        CallResultItem(postId,id);

        Log.i(TAG, "getIntentValues: id= " + id + "post_Id=" + postId);
    }


    public void CallResultItem(String postId, String id) {

        listResult=new ArrayList<>();
        Call<List<ResultItem>> call = RestApiClient.getInstance().getMyApi().getResult(postId, id);
        call.enqueue(new Callback<List<ResultItem>>() {
            @Override
            public void onResponse(Call<List<ResultItem>> call, Response<List<ResultItem>> response) {

                if (response.isSuccessful()){
                    listResult=response.body();

                    if (listResult.size()>0){
                        postIdTextView.setText(" "+listResult.get(0).getPostId());
                        idTextView.setText(" "+listResult.get(0).getId());
                        nameTextView.setText(" "+listResult.get(0).getName());
                        emailTextView.setText(" "+listResult.get(0).getEmail());
                        bodyTextView.setText(" "+listResult.get(0).getBody());
                    }else {
                        Toast.makeText(getApplicationContext(),"FAILLEDDD",Toast.LENGTH_LONG).show();
                    }

                }




            }

            @Override
            public void onFailure(Call<List<ResultItem>> call, Throwable t) {

                Log.i(TAG, "onResponseResultItem FAAILED " );


            }
        });
    }


    public void Init(){

        postIdTextView=(TextView) findViewById(R.id.postIdResultTextView);
        idTextView=(TextView) findViewById(R.id.idResultTextView);
        nameTextView=(TextView) findViewById(R.id.nameResultTextView);
        emailTextView=(TextView) findViewById(R.id.emailResultTextView);
        bodyTextView=(TextView) findViewById(R.id.bodyResultTextView);
    }


}