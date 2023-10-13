package com.jsgk.retrofit;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UserAPIadapter extends RecyclerView.Adapter<UserAPIadapter.ViewHolder> {

    List<UserAPImodel> userlist;
    Context context;

    public UserAPIadapter(List<UserAPImodel> userlist, Context context) {
        this.userlist = userlist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_view_api, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserAPImodel userAPImodel = userlist.get(position);
        holder.fristname.setText(userAPImodel.getFristname());
        holder.lastname.setText(userAPImodel.getLastname());
        String uri = userAPImodel.imgAvatar;

        Uri imguri = Uri.parse(uri);
        Glide.with(context)
                .load(imguri)
                .into(holder.imgAvatar);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView  fristname,lastname;
        ImageView imgAvatar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fristname=itemView.findViewById(R.id.txtFristname);
            lastname=itemView.findViewById(R.id.txtLastname);
            imgAvatar=itemView.findViewById(R.id.imgAvatar);

        }
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }
}
