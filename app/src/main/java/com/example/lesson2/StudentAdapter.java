package com.example.lesson2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    private ArrayList<Student> currentList = new ArrayList<>();

    public StudentAdapter(ArrayList<Student> data) {
        currentList.addAll(data);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        return new MyViewHolder(inflater.inflate(R.layout.recycle_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        viewHolder.populateItem(currentList.get(position));
    }

    @Override
    public int getItemCount() {
        return currentList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView studentPic;
        TextView studentName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            studentPic = itemView.findViewById(R.id.itemImage);
            studentName = itemView.findViewById(R.id.itemTitle);
        }

        public void populateItem(Student currentStudent) {
            studentPic.setImageResource(currentStudent.getPicRes());
            studentName.setText(currentStudent.getName());
        }
    }
}
