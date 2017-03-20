package com.example.alasif.tourmate.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alasif.tourmate.Model.EventModel;
import com.example.alasif.tourmate.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by asif on 2/27/17.
 */

public class ShowEventDetailsRecyclerViewAdapter extends RecyclerView.Adapter<ShowEventDetailsRecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<EventModel> data = Collections.emptyList();

    public ShowEventDetailsRecyclerViewAdapter(Context context, List<EventModel> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.event_details_custom_row_for_recycler_view,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        EventModel current = data.get(position);
        holder.startingPlace.setText(current.getEventStartFrom());
        holder.destination.setText(current.getEventLocationName());
        holder.startingDate.setText(current.getEventStartDate());
        holder.endingDate.setText(current.getEventEndDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView startingPlace, destination,startingDate,endingDate;
        public MyViewHolder(View itemView) {
            super(itemView);
            startingPlace = (TextView) itemView.findViewById(R.id.startingLocationTextView);
            destination = (TextView) itemView.findViewById(R.id.destinationTextView);
            startingDate = (TextView) itemView.findViewById(R.id.startingDateTextView);
            endingDate = (TextView) itemView.findViewById(R.id.endDateTextView);
        }
    }
}
