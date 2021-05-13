package com.jithu.tutorialapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder> {

    List<ModuleModel> moduleModelList;
    OnModuleClickListen onModuleClickListen;

    public ModuleAdapter(List<ModuleModel> moduleModelList, OnModuleClickListen onModuleClickListen) {
        this.moduleModelList = moduleModelList;
        this.onModuleClickListen = onModuleClickListen;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.module_single_item, parent, false);
        return new ViewHolder(view, onModuleClickListen);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.module_name.setText(moduleModelList.get(position).getModule_name());
    }

    @Override
    public int getItemCount() {
        return moduleModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        OnModuleClickListen onClickListen;
        TextView module_name;

        public ViewHolder(@NonNull View itemView, OnModuleClickListen onModuleClickListen) {
            super(itemView);

            module_name = itemView.findViewById(R.id.module_name);
            this.onClickListen = onModuleClickListen;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickListen.onModuleClick(getAdapterPosition());
        }
    }

    public interface OnModuleClickListen {
        void onModuleClick(int position);
    }

}
