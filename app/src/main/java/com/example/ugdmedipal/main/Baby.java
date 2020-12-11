package com.example.ugdmedipal.main;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ugdmedipal.R;

public class Baby extends Fragment {
    TextView weight, length;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        root = inflater.inflate(R.layout.fragment_baby, container, false);
        weight = (TextView)root.findViewById(R.id.baby_weight);
        length = (TextView)root.findViewById(R.id.baby_length);
        String weight_string = "<b>" + "Baby's Weight: " + "</b> " + "2.47 oz.";
        weight.setText(Html.fromHtml(weight_string));
        String length_string = "<b>" + "Baby's Length: " + "</b> " + "3.98 in.";
        length.setText(Html.fromHtml(length_string));
        return root;
    }
}
