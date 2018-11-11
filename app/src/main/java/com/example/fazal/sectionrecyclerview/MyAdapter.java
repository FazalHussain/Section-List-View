package com.example.fazal.sectionrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * My Adapter Class is used to collect the Multiple Child View to represent a parent view
 * @version 1.0
 * @author Fazal Hussain
 */

public class MyAdapter extends ArrayAdapter<Item> {

    List<Item> list;

    /**
     * Constructor
     * Construct the Adapter for list view.
     *
     * @param context holding the reference of an activity
     * @param resource id for a layout.
     * @param objects collection of data i.e Section & Item
     */
    public MyAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        list = objects;
    }


    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        ItemViewHolder holder = null;
        HeaderViewHolder holder1 = null;

        //Fetch the current item
        Item item = list.get(position);

        //Check if the view is null inflate the layout.
        if (convertView == null){

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            //Verify that the item is section or item.
            // If it is section inflate section layout
            //other wise inflate item layout and set the specific holder in view
            if (item.isSection()){
                HeaderModel headerModel = (HeaderModel) item;
                convertView = inflater.inflate(R.layout.header_row, parent, false);
                holder1 = new HeaderViewHolder(convertView);
                convertView.setTag(holder1);
            } else {
                ItemModel itemModel = (ItemModel) item;
                convertView = inflater.inflate(R.layout.item_row, parent, false);
                holder = new ItemViewHolder(convertView);
                convertView.setTag(holder);
            }
        } else {
            holder = (ItemViewHolder) convertView.getTag();
            holder1 = (HeaderViewHolder) convertView.getTag();
        }

        if (item.isSection()){
            HeaderModel headerModel = (HeaderModel) item;
            holder1.tv1.setText(headerModel.getTitle());
        } else {
            ItemModel itemModel = (ItemModel) item;
            holder.tv1.setText(itemModel.getTitle());
            holder.tv2.setText(itemModel.getSubTitle());
        }

        return convertView;
    }

    /**
     * Item View Holder class
     */
    public class ItemViewHolder {

        TextView tv1;
        TextView tv2;

        public ItemViewHolder(@NonNull View itemView) {
            tv1 = itemView.findViewById(R.id.textView);
            tv2 = itemView.findViewById(R.id.textView2);
        }
    }

    /**
     * Header View Holder
     */
    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView tv1;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.textView3);
        }
    }
}
