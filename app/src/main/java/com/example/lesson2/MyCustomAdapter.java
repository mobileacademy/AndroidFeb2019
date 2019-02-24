package com.example.lesson2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> data;
    private String currentItem;

    public MyCustomAdapter(Context context, ArrayList<String> dataSource) {
        this.context = context;
        data = new ArrayList<>();
        data.addAll(dataSource);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        currentItem = data.get(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.titleTextView = convertView.findViewById(R.id.itemTitle);
//            viewHolder.itemIcon = convertView.findViewById(R.id.itemIcon);
//            viewHolder.itemBtn = convertView.findViewById(R.id.itemBtn);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.titleTextView.setText(currentItem);

        return convertView;
    }

    class ViewHolder {
        TextView titleTextView;
    }
}
