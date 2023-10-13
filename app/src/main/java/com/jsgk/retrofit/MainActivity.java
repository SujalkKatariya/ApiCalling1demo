package com.jsgk.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.service.autofill.UserData;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText edtText1;
    TextView textview,txtLastname;
    Button btn1;
    ImageView avatar;
    RecyclerView recyclerView;

    UserAPIadapter userAPIadapter;

    List<UserAPImodel> userAPImodelList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        RetrofitInstance.getInstance().apigetrequest.getUsers().enqueue(new Callback<usermodal>() {
            @Override
            public void onResponse(Call<usermodal> call, Response<usermodal> response) {
                if (response.isSuccessful()) {
                    usermodal userModal = response.body();
                    List<usermodal.Data> users = userModal.getData();

                    for (usermodal.Data user : users) {
                        Log.i("TAG", "First Name: " + user.getFirst_name());
                        Log.i("TAG", "Last Name: " + user.getLast_name());
                        Log.i("TAG", "Email: " + user.getEmail());
                        Log.i("TAG", "Avatar: " + user.getAvatar());
                        userAPImodelList.add(new UserAPImodel(user.getFirst_name(), user.getLast_name(),user.getAvatar()));
                    }


                    userAPIadapter = new UserAPIadapter(userAPImodelList,getApplicationContext());
                    recyclerView.setAdapter(userAPIadapter);
                } else {
                    // Handle the error or display a message if the request is not successful
                    Log.e("TAG", "Request failed with code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<usermodal> call, Throwable t) {
                // Handle the failure of the request
                t.printStackTrace();
            }
        });



    }

}