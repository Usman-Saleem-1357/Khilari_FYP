package com.example.khilari;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class listAdapter extends ArrayAdapter<Users> {

    private Context mContext;
    int mResource;
    public listAdapter(Context context,int resource, ArrayList<Users> usersArrayList)
    {
        super(context,R.layout.listitem,usersArrayList);
        mContext = context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String name = getItem(position).name;
        String interest=getItem(position).interests;
        String phone = getItem(position).phoneNo;
        String time = getItem(position).time;
        int imgid = getItem(position).imageID;
        Users user = new Users(name,interest,phone,time,imgid);
        LayoutInflater inflater= LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        ImageView imageView = convertView.findViewById(R.id.profile);
        TextView userName = convertView.findViewById(R.id.name);
        TextView interests = convertView.findViewById(R.id.interest);
        TextView time1 = convertView.findViewById(R.id.time);


        imageView.setImageResource(user.imageID);
        userName.setText(user.name);
        interests.setText(user.interests);
        time1.setText(user.time);


        return convertView;
    }
}
