package com.example.mission13;

import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    ArrayList<User> items = new ArrayList<User>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.item_view, parent, false);

        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView userDate;
        TextView userPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.userName);
            userDate = itemView.findViewById(R.id.userDate);
            userPhone = itemView.findViewById(R.id.userPhone);
        }

        public void setItem(User item){
            userName.setText(item.getName());
            userDate.setText(item.getDate());
            userPhone.setText(item.getPhone());
        }
    }

    public void addItem(User item){
        items.add(item);
    }

    public void setItems(ArrayList<User> items){
        this.items = items;
    }

    public User getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, User item){
        items.set(position, item);
    }
}
