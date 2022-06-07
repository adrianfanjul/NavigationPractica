package com.tokioschool.navigationpractica.features.home.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tokioschool.navigationpractica.databinding.ItemlayoutListaCochesBinding;
import com.tokioschool.navigationpractica.domain.CarItem;
import com.tokioschool.navigationpractica.features.home.adapters.viewholders.ListaCochesViewHolder;

import java.util.List;

public class ListaCochesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CarItem> items;
    private OnItemCarClick listener;

    public ListaCochesAdapter(List<CarItem> items, OnItemCarClick onItemCarClick) {
        this.items = items;
        this.listener=onItemCarClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemlayoutListaCochesBinding binding = ItemlayoutListaCochesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ListaCochesViewHolder(binding,listener);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ListaCochesViewHolder){
            ((ListaCochesViewHolder)holder).bind(items.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnItemCarClick{
        void onItemClickCar(CarItem carItem);
    }
}
