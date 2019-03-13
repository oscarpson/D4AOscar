package com.digital4africa.oscar.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.digital4africa.oscar.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewModel  extends RecyclerView.ViewHolder {
   public  TextView title,content,slogan,date;
   public ImageView imgnext;
    public PostViewModel(@NonNull View itemView) {
        super(itemView);
        title=itemView.findViewById(R.id.txttitle);
        date=itemView.findViewById(R.id.txtdate);
        slogan=itemView.findViewById(R.id.txtslogan);
        content=itemView.findViewById(R.id.txtcontent);
        imgnext=itemView.findViewById(R.id.imgnext);


    }
}
