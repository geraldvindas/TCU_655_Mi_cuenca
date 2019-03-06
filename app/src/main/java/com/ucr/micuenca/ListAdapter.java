package com.ucr.micuenca;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import android.support.v7.widget.RecyclerView;
import android.view.View.OnClickListener;

import java.util.List;


/**
 * {@link android.support.v7.widget.RecyclerView}
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<String> temp;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle, mDescription;

        public MyViewHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.tv_item_title);
            mDescription = (TextView) view.findViewById(R.id.tv_item_description);
        }

    }

    public ListAdapter(List<String> temp_list){
        this.temp = temp_list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        //View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        String s = temp.get(position);
        myViewHolder.mTitle.setTextColor(Util.getColor(position, context));
        myViewHolder.mTitle.setText(s);
    }


    @Override
    public int getItemCount() {
        return temp.size();
    }


}
