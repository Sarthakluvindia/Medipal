package com.example.ugdmedipal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.pregnancy,R.drawable.childcare,R.drawable.vacc};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.viewpagerlayout,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.vpl_image);
        imageView.setImageResource(images[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 0){
                    startActivityPreg(context);
                }else if(position == 1){
                    Toast.makeText(context,"Go to Child Care tab",Toast.LENGTH_SHORT).show();
                }else{
                    startActivityVacc(context);
                }
            }
        });

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view,0);
        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager)container;
        View view = (View)object;
        vp.removeView(view);
    }
    public void startActivityVacc(Context context) {
        Intent intent = new Intent(context, Vaccination.class);
        context.startActivity(intent);
    }

    public void startActivityPreg(Context context) {
        Intent intent = new Intent(context, Pregnancy.class);
        context.startActivity(intent);
    }
}
