package com.example.mission14;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> implements OnItemClickListener {

    ArrayList<ItemList> items = new ArrayList<ItemList>();
    OnItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view, parent, false);

        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemList item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(ItemList item) {
        items.add(item);
    }

    public void setItems(ArrayList<ItemList> items) {
        this.items = items;
    }

    public ItemList getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, ItemList item) {
        items.set(position, item);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder viewHolder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(viewHolder, view, position);
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName;
        TextView itemPrice;
        TextView itemExam;
        View itemsView;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            itemExam = itemView.findViewById(R.id.itemExam);
            itemsView = itemView.findViewById(R.id.itemView);
            itemsView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, itemsView, position);
                    }
                }
            });

        }

        public void setItem(ItemList item) {
            itemImage.setImageResource(item.getItemImage());
            itemName.setText(item.getItemName());
            itemPrice.setText(item.getItemPrice());
            itemExam.setText(item.getItemExam());
        }
    }
}
