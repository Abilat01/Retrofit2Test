package com.abilat.retrofit2test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.boredapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serverApi serverApi = retrofit.create(serverApi.class);
        Call<pojo> messages = serverApi.messages();

        textView = (TextView) findViewById(R.id.textView);

                //textView.setText("A change in text, thank you very much");


        Log.d("response", "  jkjkkk");
        messages.enqueue(new Callback<pojo>() {
            @Override
            public void onResponse(Call<pojo> call, Response<pojo> response) {

                Log.d("response", response.body().getActivity() + " k");
                textView.setText(response.body().getActivity() + " ");



            }

            @Override
            public void onFailure(Call<pojo> call, Throwable t) {
                Log.d("response", t.getMessage() + "  t");

            }


        });

    }


}