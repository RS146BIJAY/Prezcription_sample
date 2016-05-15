package com.example.rishavz_sagar.application;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/*
The content of the chat messages is stored in table chats in messages.sqlite database in assest folder.
The contents are fetched inside onCreate function of MainActivity class and updated in Recyclerview inside onActivityAttached function of this class.
 */

public class ChatFragment extends Fragment {

    SQLiteDatabase mydb;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_chat, container, false);
        recyclerView= (RecyclerView) v.findViewById(R.id.recyler);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Recycler_adapter adapter=new Recycler_adapter(getActivity(),MainActivity.messages);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
