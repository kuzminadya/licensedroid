package com.raychenon.licensedroid;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.raychenon.licensedroid.viewholder.OpenSourceDefaultViewHolder;
import com.raychenon.licensedroid.viewholder.OpenSourceViewHolder;

import java.util.List;

/**
 * @author Raymond Chenon
 */
public class OpenSourceAdapter<O extends OpenSourceViewHolder> extends RecyclerView.Adapter<OpenSourceViewHolder> {

    private final List<OpenSource> openSources;
    private final OpenSourceTransformer transformer;
    private OpenSourceViewHolder.Factory factory;

    public OpenSourceAdapter(final List<OpenSource> openSourceList) {
        this.openSources = openSourceList;
        this.transformer = new OpenSourceTransformer();
        if (openSources == null) {
            throw new NullPointerException("Data cannot be null!");
        }
    }

    public OpenSourceAdapter(final List<OpenSource> openSourceList, final OpenSourceViewHolder.Factory factory) {
        this.openSources = openSourceList;
        this.transformer = new OpenSourceTransformer();
        this.factory = factory;

        if (openSources == null || factory == null) {
            throw new NullPointerException("Neither data or factory can be null!");
        }
    }

    @Override
    public OpenSourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (factory == null) {
            return OpenSourceDefaultViewHolder.createViewHolder(parent, viewType);
        }
        return factory.createViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(OpenSourceViewHolder holder, int position) {
        OpenSource openSource = getItem(position);
        OpenSourceModel item = transformer.transform(openSource);

        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return openSources != null ? openSources.size() : 0;
    }

    private OpenSource getItem(final int position) {
        return openSources.get(position);
    }
}
