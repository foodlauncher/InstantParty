package com.example.instantparty;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<Restaurant> restaurants;
    private Context context;
    private int rowLayout;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textOne;
        TextView textTwo;
        TextView textThree;
        TextView textFour;
        TextView textFive;
        TextView textSix;
        Button callBtn;
        public ViewHolder(View v) {
            super(v);
            textOne = (TextView) v.findViewById(R.id.textView4);
            textTwo = (TextView) v.findViewById(R.id.textView5);
            textThree = (TextView) v.findViewById(R.id.textView6);
            textFour = (TextView) v.findViewById(R.id.textView7);
            textFive = (TextView) v.findViewById(R.id.textView8);
            textSix = (TextView) v.findViewById(R.id.textView10);
            callBtn = v.findViewById(R.id.call_now);
        }
    }

    public Adapter(List<Restaurant> restaurants, int rowLayout, Context context) {
        this.restaurants = restaurants;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        holder.textOne.setText("Name: " + restaurants.get(position).getRestaurant().getName());
        holder.textTwo.setText("Address: " + restaurants.get(position).getRestaurant().getLocation().getAddress());
        //holder.textThree.setText("Average Rating: " + restaurants.get(position).getUserRating().getAggregateRating());
        holder.textFour.setText("Cuisine: " + restaurants.get(position).getRestaurant().getCuisines());
        holder.textFive.setText("Phone number: " + restaurants.get(position).getRestaurant().getPhoneNumbers());
        holder.textSix.setText("Has Table booking: " + restaurants.get(position).getRestaurant().getHasTableBooking());
//        Uri u = Uri.parse(restaurants.get(position).getRestaurant().getPhoneNumbers());
//        if(u!=null) {
//            holder.callBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent i = new Intent(Intent.ACTION_DIAL, u);
//                    try
//                    {
//                        // Launch the Phone app's dialer with a phone
//                        // number to dial a call.
//                        context.startActivity(i);
//                    }
//                    catch (SecurityException s)
//                    {
//                        // show() method display the toast with
//                        // exception message.
//                        Toast.makeText(context, "Error: " + s.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
//        else {
//            holder.callBtn.setVisibility(View.INVISIBLE);
//        }

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }
}