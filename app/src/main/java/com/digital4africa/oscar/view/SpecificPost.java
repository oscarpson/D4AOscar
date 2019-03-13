package com.digital4africa.oscar.view;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.digital4africa.oscar.MainActivity;
import com.digital4africa.oscar.model.PostList;
import com.digital4africa.oscar.model.Posts;
import com.digital4africa.oscar.presenter.PostAdapter;
import com.digital4africa.oscar.presenter.RestClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.View;

import com.digital4africa.oscar.R;

import java.util.ArrayList;

public class SpecificPost extends AppCompatActivity {
    RecyclerView rcvpost;
    PostAdapter padapter;
    ArrayList<Posts> posts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_post);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rcvpost=findViewById(R.id.rcvpost);
        rcvpost.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcvpost.setAdapter(null);

//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        final ProgressDialog loading = ProgressDialog.show(SpecificPost.this, "Fetching...", "Please wait...", false, false);
        Call<PostList> resp2= RestClient.getApiService().allpostlist();
        resp2.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                loading.dismiss();
                posts=response.body().getPosts();
                padapter=new PostAdapter(posts);
                rcvpost.setAdapter(padapter);

            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                loading.dismiss();
                Log.e("errorsvr",t.getMessage());
            }
        });
    }

}
