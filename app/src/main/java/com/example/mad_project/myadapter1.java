package com.example.mad_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class myadapter1 extends RecyclerView.Adapter<myViewHolder1>
{
    private List<model1> dataholder1;



    public myadapter1(List<model1> dataholder1, History mainActivity)
    {
        this.dataholder1 = dataholder1;
    }

    @NonNull
    @Override
    public myViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow1, parent, false);
        return new myViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder1 holder, int position) {
        model1 e = dataholder1.get(position);
        holder.bind(e);
    }

    @Override
    public int getItemCount()
    {
        return dataholder1.size();
    }

    public void updateList(ArrayList<model1> list) {
        dataholder1.clear();
        dataholder1.addAll(list);
        notifyDataSetChanged();
    }
}



class myViewHolder1 extends RecyclerView.ViewHolder
{
    TextView hId, hname, hdate, hloc, hphno,htype;

    public myViewHolder1(@NonNull View itemView) {
        super(itemView);
        hId = itemView.findViewById(R.id.hid2);
        hname = itemView.findViewById(R.id.hname2);
        hdate = itemView.findViewById(R.id.hdate2);
        hloc = itemView.findViewById(R.id.hlocation2);
        hphno = itemView.findViewById(R.id.hphno2);
        htype = itemView.findViewById(R.id.htype2);
    }

    public void bind(model1 e)
    {
        hId.setText(e.hid);
        hname.setText(e.hname);
        hdate.setText(e.hdate);
        hloc.setText(e.hlocation);
        hphno.setText(e.hphno);
        htype.setText(e.htype);
    }
}
