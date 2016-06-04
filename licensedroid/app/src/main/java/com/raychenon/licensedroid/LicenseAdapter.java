package com.raychenon.licensedroid;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Raymond Chenon
 */
public class LicenseAdapter extends RecyclerView.Adapter<LicenseViewHolder>{

    private List<OpenSource> openSources;

    public LicenseAdapter(final List<OpenSource> openSourceList){
        this.openSources = openSourceList;
    }

    @Override
    public LicenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.license_item,parent,false);
        return new LicenseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LicenseViewHolder holder, int position) {
        OpenSource item = getItem(position);

        holder.tvName.setText(String.format("%s %s",item.getName(), item.getAuthor()));
        holder.tvLicense.setText(item.getLicense());
    }

    @Override
    public int getItemCount() {
        return openSources != null ? openSources.size() : 0;
    }

    private OpenSource getItem(final int position){
        return openSources.get(position);
    }
}
