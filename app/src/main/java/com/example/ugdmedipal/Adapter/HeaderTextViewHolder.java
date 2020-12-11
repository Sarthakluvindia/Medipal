package com.example.ugdmedipal.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.ugdmedipal.R;
import com.example.ugdmedipal.model.HeaderTextItem;
import com.example.ugdmedipal.model.TimelineItem;

public class HeaderTextViewHolder extends BaseViewHolder {

    private TextView tvHeader;

    public HeaderTextViewHolder(@NonNull View itemView) {
        super(itemView);
        tvHeader = itemView.findViewById(R.id.header_text);
    }

    @Override
    void setData(TimelineItem item) {

        HeaderTextItem headerTextItem = item.getHeaderTextItem();
        tvHeader.setText(headerTextItem.getHeaderText());

    }
}
