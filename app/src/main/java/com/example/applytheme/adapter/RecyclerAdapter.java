package com.example.applytheme.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.applytheme.R;
import com.example.applytheme.model.Landscape;

import java.util.List;

/**
 * Created by jose on 23/02/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private static final String TAG = RecyclerAdapter.class.getSimpleName();

    private List<Landscape> mData;
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context, List<Landscape> data) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder");

        Landscape currentObj = mData.get(position);
        holder.setData(currentObj, position);

        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void removeItem(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mData.size());
    }

    public void addItem(int position, Landscape landscape) {
        mData.add(position, landscape);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, mData.size());
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView imgThumb, imgDelete, imgAdd;
        int position;
        Landscape current;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txvTitle);
            imgThumb = (ImageView) itemView.findViewById(R.id.imgRow);
            imgDelete = (ImageView) itemView.findViewById(R.id.img_row_delete);
            imgAdd = (ImageView) itemView.findViewById(R.id.img_row_add);
        }

        public void setData(Landscape current, int position) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            this.position = position;
            this.current = current;
        }

        public void setListeners() {
            imgDelete.setOnClickListener(MyViewHolder.this);
            imgAdd.setOnClickListener(MyViewHolder.this);
        }

        @Override
        public void onClick(View view) {
            Log.i(TAG, "onClick before operation at position: " + position + ". Size: " + mData.size());
            switch (view.getId()) {
                case R.id.img_row_delete:
                    removeItem(position);
                    break;
                case R.id.img_row_add:
                    addItem(position, current);
                    break;
            }
            Log.i(TAG, "onClick after operation - Size: " + mData.size());
        }
    }
}
