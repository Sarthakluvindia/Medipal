package com.example.ugdmedipal.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.ugdmedipal.R;
import com.example.ugdmedipal.model.PostTextItem;
import com.example.ugdmedipal.model.TimelineItem;

public class PostTextViewHolder extends BaseViewHolder {

    private TextView txtPost,txtTime;
    private ImageView imgUser;

    public PostTextViewHolder(@NonNull View itemView) {
        super(itemView);
        txtPost = itemView.findViewById(R.id.post_text_content);
        txtTime = itemView.findViewById(R.id.post_text_time);
        imgUser = itemView.findViewById(R.id.post_text_img);
    }

    @Override
    void setData(TimelineItem item) {

        PostTextItem postTextItem = item.getPostTextItem();
        txtPost.setText(postTextItem.getPostText());
        txtTime.setText(postTextItem.getTime());
        Glide.with(itemView.getContext()).load(postTextItem.getImgUser()).into(imgUser);
    }


}
