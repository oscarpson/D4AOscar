package com.digital4africa.oscar.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digital4africa.oscar.OnclickActivity;
import com.digital4africa.oscar.R;
import com.digital4africa.oscar.model.PostViewModel;
import com.digital4africa.oscar.model.Posts;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends RecyclerView.Adapter<PostViewModel> {
    List<Posts>posts;
    Context context;

    public PostAdapter(List<Posts> posts) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout,parent,false);
        PostViewModel holder=new PostViewModel(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewModel holder, int position) {
    final Posts postobj=posts.get(position);

    if (postobj.getContent().length() > 60){
        holder.content.setText(postobj.getContent().charAt(60)+"....");
    }
    holder.slogan.setText("Slug: "+postobj.getSlug());
    holder.date.setText(postobj.getDate());
    holder.title.setText("Title: "+postobj.getTitle());
    holder.imgnext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent ints=new Intent(v.getContext(),OnclickActivity.class);
            ints.putExtra("fulldoc",postobj.getContent());
            v.getContext().startActivity(ints);
        }
    });
    }

    @Override
    public int getItemCount() {
        return (posts!=null)?posts.size():0;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
