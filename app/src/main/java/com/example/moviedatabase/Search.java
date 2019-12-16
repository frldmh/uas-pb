package com.example.moviedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Search extends AppCompatActivity {
    ListView listView;
    private List<MovieItem> movieItemList;
    private String query;
    private String KEY_QUERY = "TONY STARK";

    private JsonPlaceHolderApi jsonPlaceHolderApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        listView = findViewById(R.id.listView);
        movieItemList = new ArrayList<>();

        Bundle getData = getIntent().getExtras();
        query = getData.getString("KEY_QUERY");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rest.farzain.com/api/gsmarena/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        getPost();
//        getComment();
    }

    private void getPost() {

        Call<List<Post>> call = jsonPlaceHolderApi.getPost("HG8ughA3BX4THPtdibcgwV2QR",query);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                if(!response.isSuccessful()) {
//                    textViewResult.setText("Code :" + response.code());
//                    return;
//                }

                List<Post> posts = response.body();

                for(Post post:posts) {
                    MovieItem movieItem = new MovieItem(
                            post.getTitle(),
                            post.getUrl(),
                            post.getImg(),
                            ".");

                    movieItemList.add(movieItem);
                }

                ListViewAdapter adapter = new ListViewAdapter(movieItemList, getApplicationContext());
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
//                textViewResult.setText(t.getMessage());
            }
        });
    }
}