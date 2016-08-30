package com.raychenon.licensedroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Raymond Chenon
 */
public abstract class OpenSourceCustomViewHolder extends RecyclerView.ViewHolder{

    public OpenSourceCustomViewHolder(View itemView){
        super(itemView);
    }

    public abstract void bindData(final OpenSourceUIModel item);

}
