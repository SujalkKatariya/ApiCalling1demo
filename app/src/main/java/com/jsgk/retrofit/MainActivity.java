package com.jsgk.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    EditText edtText1;
    TextView textview,txtLastname;
    Button btn1;
    ImageView avatar;

    interface RequestUserdata{
        @GET("/api/users/{uid}")
        Call<UserModel> getuser(@Path("uid") String uid);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtText1=findViewById(R.id.edtText1);
        textview=findViewById(R.id.textview);
        btn1=findViewById(R.id.btn1);
        avatar=findViewById(R.id.avatar);
        txtLastname=findViewById(R.id.txtlastname);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!edtText1.getText().toString().isEmpty()) {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://reqres.in/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    RequestUserdata requestUserdata = retrofit.create(RequestUserdata.class);
                    requestUserdata.getuser(edtText1.getText().toString()).enqueue(new Callback<UserModel>() {
                        @Override
                        public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                            textview.setText(Objects.requireNonNull(response.body()).getData().getFirst_name());
                            txtLastname.setText(response.body().getData().getLast_name());
                            String img = response.body().getData().getAvatar();
                            Uri imguri = Uri.parse(img);
                            Glide.with(getApplicationContext())
                                    .load(imguri)
                                    .into(avatar);
                        }

                        @Override
                        public void onFailure(Call<UserModel> call, Throwable t) {
                            textview.setText(t.getMessage());
                        }
                    });

            }else{
                    Toast.makeText(MainActivity.this, "Enter a Uid please", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}