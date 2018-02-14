package com.aisha.sqliteagain;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aisha on 10/02/2018.
 */

public class NotificationListAdapter extends RecyclerView.Adapter<NotificationListAdapter.ViewHolder> {
    private Context context;
    private List<Notification> notificationList;

    public NotificationListAdapter(Context context, List<Notification> notificationList) {
        this.context = context;
        this.notificationList = notificationList;
    }

    @Override
    public NotificationListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from (context);
        View view = inflater.inflate (R.layout.notification_items, null);
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_items,parent,false));

    }

    @Override
    public void onBindViewHolder(NotificationListAdapter.ViewHolder holder, int position) {
        Notification group = notificationList.get (position);
        holder.Title.setText (group.getTitle ());
        holder.Details.setText (group.getDetails ());
        holder.DateTime.setText(group.getDateTime());

        byte[] notiImage = group.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(notiImage, 0 , notiImage.length);
        holder.imageView.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        TextView Title, Details , DateTime ;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            Title = itemView.findViewById (R.id.txtTitle);
            Details = itemView.findViewById (R.id.txtDetails);
            DateTime = itemView.findViewById(R.id.txtDate);
            imageView = itemView.findViewById(R.id.txtimageView);
        }
    }


}
