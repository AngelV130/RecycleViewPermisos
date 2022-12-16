package com.example.recycleviewpermisos.Adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewpermisos.Model.Perrmisos;
import com.example.recycleviewpermisos.R;

import java.util.List;

public class PermisosAdapter extends RecyclerView.Adapter<PermisosAdapter.ViewHolder>  {
    List<Perrmisos> lp;
    final PermisosAdapter.OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(Perrmisos item);
    }

    public PermisosAdapter(List<Perrmisos> lp, PermisosAdapter.OnItemClickListener listener) {
        this.lp = lp;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PermisosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        return new PermisosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PermisosAdapter.ViewHolder holder, int position) {
        holder.setData(lp.get(position));
    }

    @Override
    public int getItemCount() {
        return lp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        Perrmisos item;
        public  ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt1);
        }
        public void setData(Perrmisos item)
        {
            this.item=item;
            name.setText((item.getNombre()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }

    }

}
