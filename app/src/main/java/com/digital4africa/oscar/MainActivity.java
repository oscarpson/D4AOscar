package com.digital4africa.oscar;

import android.app.ProgressDialog;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.digital4africa.oscar.model.PostList;
import com.digital4africa.oscar.model.Posts;
import com.digital4africa.oscar.presenter.PostAdapter;
import com.digital4africa.oscar.presenter.RestClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    RecyclerView rcvpost;
    PostAdapter padapter;
    ArrayList<Posts>posts;

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    //getRecentPost();
//                    return true;
//                case R.id.navigation_dashboard:
//                    //mTextMessage.setText(R.string.title_dashboard);
//                    return true;
//                case R.id.navigation_notifications:
//                   // mTextMessage.setText(R.string.title_notifications);
//                    return true;
//            }
//            return false;
//        }
//    };

    private void getRecentPost(List<Posts> posts) {
        padapter=new PostAdapter(posts);
        rcvpost.setAdapter(padapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         rcvpost=findViewById(R.id.rcvpost);
         rcvpost.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
         rcvpost.setAdapter(null);

//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        final ProgressDialog loading = ProgressDialog.show(MainActivity.this, "Fetching...", "Please wait...", false, false);
        Call<PostList> resp2= RestClient.getApiService().postlist();
        resp2.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                loading.dismiss();
                posts=response.body().getPosts();
                getRecentPost(posts);

            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                loading.dismiss();
                Log.e("errorsvr",t.getMessage());
            }
        });
    }

}
