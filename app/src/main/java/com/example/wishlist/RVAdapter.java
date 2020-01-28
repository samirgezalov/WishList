package com.example.wishlist;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemViewHolder> {

    List<MainActivity.WishItem> wishItems;


    RVAdapter(List<MainActivity.WishItem> wishItems) {
        this.wishItems = wishItems;

    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, viewGroup, false);
        ItemViewHolder ivh = new ItemViewHolder(v);

        return ivh;
    }


    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder,final int i) {
        itemViewHolder.itemName.setText(wishItems.get(i).name);
        itemViewHolder.itemPrice.setText(wishItems.get(i).price + "");
        itemViewHolder.itemPhoto.setImageResource(wishItems.get(i).photoID);
        itemViewHolder.itemState.setChecked(wishItems.get(i).isSelected);
        itemViewHolder.itemState.setOnClickListener(new View.OnClickListener(){



            @Override
            public void onClick(View v) {
                wishItems.get(i).isSelected=!wishItems.get(i).isSelected;
//                Log.i("Testing", wishItems.get(i).name + wishItems.get(i).isSelected);
            MainActivity.textView.setText(MainActivity.sumOfSelectedItems()+"");
            }

        });

    }


    @Override
    public int getItemCount() {
        return wishItems.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }





    public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView itemName;
        TextView itemPrice;
        ImageView itemPhoto;
        CheckBox itemState;

        ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            cv = (CardView) itemView.findViewById(R.id.cv);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemPrice = (TextView) itemView.findViewById(R.id.item_age);
            itemPhoto = (ImageView) itemView.findViewById(R.id.item_photo);
            itemState = (CheckBox) itemView.findViewById((R.id.checkBox));
        }


        @Override
        public void onClick(View v) {
// Оставил чтобы дать понять что одна из попыток реализации была такова, не сработало быстро как хотелось

        }
    }
}