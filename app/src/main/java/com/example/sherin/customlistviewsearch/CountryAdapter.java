package com.example.sherin.customlistviewsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryAdapter extends BaseAdapter {
    private Context context;
    String[] title;
    int[] image;

    public CountryAdapter(Context context, String[] title, int[] image) {
        this.context = context;
        this.title = title;
        this.image = image;
    }

    @Override
    public int getCount() {
        return title.length;//item alist
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//layout convert


        if (view == null) {
            view = inflater.inflate(R.layout.sample_layout, null);

        }
        ImageView imageView = view.findViewById(R.id.imageId);
        TextView textView = view.findViewById(R.id.titleid);

        imageView.setImageResource(image[i]);
        textView.setText(title[i]);
        return view;
    }
    //adapter class receive
    public void filter(String[] name, int[] pic) {
        title=name;
        image=pic;
        //update
        notifyDataSetChanged();
    }
}