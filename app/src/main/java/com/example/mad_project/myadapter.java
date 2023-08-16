package com.example.mad_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class myadapter extends RecyclerView.Adapter<myViewHolder>
{
    private List<model> dataholder;
    private ItemClick click;


    public myadapter(List<model> dataholder, DonationList mainActivity)
    {
        this.dataholder = dataholder;
        this.click= (ItemClick) mainActivity;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        model e = dataholder.get(position);
        holder.bind(e,click);
    }

    @Override
    public int getItemCount()
    {
        return dataholder.size();
    }

    public void updateList(ArrayList<model> list) {
        dataholder.clear();
        dataholder.addAll(list);
        notifyDataSetChanged();
    }
}



class myViewHolder extends RecyclerView.ViewHolder {


    private AppCompatTextView dId, dname, ddate, dloc, dphno;
    private ImageView img;
    public myViewHolder(@NonNull View itemView) {
        super(itemView);
        dId = itemView.findViewById(R.id.hid2);
        dname = itemView.findViewById(R.id.hname2);
        ddate = itemView.findViewById(R.id.hdate2);
        dloc = itemView.findViewById(R.id.hlocation2);
        dphno = itemView.findViewById(R.id.hphonenum2);
        img = itemView.findViewById(R.id.floatingActionButton);
    }

    public void bind(model e,ItemClick click)
    {
        dId.setText(e.id);
        dname.setText(e.name);
        ddate.setText(e.date);
        dloc.setText(e.location);
        dphno.setText(e.phno);
        img.setOnClickListener(view ->{
            click.onclick(e);
        });
    }
}

interface ItemClick
{
    public void onclick(model e);

}
