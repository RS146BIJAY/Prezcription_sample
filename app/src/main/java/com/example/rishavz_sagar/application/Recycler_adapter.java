package com.example.rishavz_sagar.application;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rishavz_sagar on 15-May-16.
 */
public class Recycler_adapter extends RecyclerView.Adapter<Recycler_adapter.VH> {

    int SELF=100;
    ArrayList<Message> list;
    Context context;

    public Recycler_adapter(Context context,ArrayList<Message> list)
    {
        this.list=list;
        this.context=context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if(viewType==SELF)
        v= LayoutInflater.from(parent.getContext()).inflate(R.layout.self_messages,parent,false);
        else
        v=LayoutInflater.from(parent.getContext()).inflate(R.layout.others_message,parent,false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.message.setText(list.get(position).getMessage());
        holder.others.setText(list.get(position).getOthers());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).type;
    }

    public static class VH extends RecyclerView.ViewHolder
    {
        TextView message,others;
        public VH(View itemView) {
            super(itemView);
            message= (TextView) itemView.findViewById(R.id.message);
            others=(TextView)itemView.findViewById(R.id.timestamp);
        }
    }
}
