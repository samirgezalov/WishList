package com.example.wishlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static TextView textView;

    public static RadioGroup currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        currency=findViewById(R.id.currency);
        currency.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                textView.setText(sumOfSelectedItems()+"");
            }
        });

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);


        Context context = this;
        initializeData();

        ArrayList<HashMap<String, String>> al = new ArrayList<>();
        HashMap<String, String> map;

        LinearLayoutManager llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);

        RVAdapter adapter = new RVAdapter(wishItems);
        rv.setAdapter(adapter);

    }






    class WishItem{
        int photoID;
        String name;
        double price;
        boolean isSelected=false;
        WishItem (String name, double price, int photoID){
            this.name = name;
            this.price=price;
            this.photoID=photoID;
        }
        void setState(){
            isSelected=!isSelected;
        }

    }
    private static List<WishItem> wishItems;

    private void initializeData(){
        wishItems = new ArrayList<>();
        wishItems.add(new WishItem("Волшебная палка", 100, R.drawable.bean1));
        wishItems.add(new WishItem("Волшебная дубинка", 22.7, R.drawable.bean3));
        wishItems.add(new WishItem("Неволшебный пистолет", 31.23, R.drawable.bean4));
    }

   public static double sumOfSelectedItems (){
        double sum = 0;
        for(WishItem item:wishItems){
            if(item.isSelected){
                sum+=item.price;
            }

        }

        switch (currency.getCheckedRadioButtonId()){
            case R.id.azn:
                return sum;
            case R.id.usd:
                return sum*1.7;
            case R.id.eur:
                return sum*1.9;
            default:
                return 0;
        }


    }


//    void updateList(double cur){
//        for(WishItem item:wishItems){
//            item.price=item.price*cur;
//        }
//
//
//    }
}
