package com.example.ugdmedipal.Adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ugdmedipal.model.TimelineItem;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    abstract void setData(TimelineItem item);

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
